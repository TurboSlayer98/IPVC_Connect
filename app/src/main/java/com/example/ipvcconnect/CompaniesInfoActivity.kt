package com.example.ipvcconnect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.Company
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import android.net.Uri
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.CommentsAdapter
import com.example.ipvcconnect.dataaccessobjects.CommentsDao
import com.example.ipvcconnect.database.AppDatabase
import com.example.ipvcconnect.models.Comment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CompaniesInfoActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var adapter: CommentsAdapter
    private lateinit var database: AppDatabase
    private lateinit var commentDao: CommentsDao
    private lateinit var latlng: LatLng
    private var commentsJob: Job? = null
    //private lateinit var company: Company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info_company)

        // Get course ID from intent and coordinates
        val companyId = intent.getIntExtra("COMPANY_ID", -1)
        val companyPhone = intent.getStringExtra("COMPANY_PHONE").toString()
        val companyEmail = intent.getStringExtra("COMPANY_EMAIL").toString()
        val companyWebsite = intent.getStringExtra("COMPANY_WEB").toString()
        latlng = LatLng(intent.getDoubleExtra("COMPANY_LAT", 0.0), intent.getDoubleExtra("COMPANY_LNG", 0.0))

        if (companyId == -1) {
            Toast.makeText(this, "${R.string.msg_error_company}", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        loadCompany(companyId)

        // Inicializar banco de dados
        database = AppDatabase.getDatabase(this)
        commentDao = database.CommentsDao()

        // Set up back button
        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener {
            finish()
        }

        // Configurar mapa
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.miniMapa) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Configurar RecyclerView para comentários
        adapter = CommentsAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView_comments)
        recyclerView.layoutManager = LinearLayoutManager(this).apply {
            reverseLayout = true
            stackFromEnd = true
        }
        recyclerView.adapter = adapter

        // Botão de enviar comentário (mantido para quem preferir clicar no botão)
        findViewById<Button>(R.id.buttonSend).setOnClickListener {
            val text = findViewById<EditText>(R.id.editText_comment).text.toString()
            if (text.isNotEmpty()) {
                val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
                val comment = Comment(null,"${R.string.comment_user}", text, date, companyId)
                lifecycleScope.launch {
                    commentDao.insertComment(comment)
                    findViewById<EditText>(R.id.editText_comment).text.clear()
                }
            }
        }

//        // Cancelar job anterior se existir
//        commentsJob?.cancel()
//
//        // Observar comentários em tempo real (em um único lifecycleScope)
//        commentsJob = lifecycleScope.launch {
//            // Usar distinctUntilChanged para evitar atualizações desnecessárias
//            commentDao.getCommentsByCompany(companyId)
//                .distinctUntilChanged()
//                .collect { comments ->
//                    val orderedList = comments
//                        .distinctBy { it.id } // Garantir que não há duplicatas
//                        .sortedByDescending { it.id }
//                    adapter.submitList(orderedList) {
//                        // Callback executado após a lista ser atualizada
//                        if (orderedList.isNotEmpty()) {
//                            recyclerView.smoothScrollToPosition(0)
//                        }
//                    }
//                }
//        }

        // Botões de contato
        findViewById<Button>(R.id.buttonCall).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${companyPhone}")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${companyEmail}")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonWeb).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(companyWebsite))
            startActivity(intent)
        }
    }

    private fun loadCompany(companyId: Int) {
        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getCompany(companyId)

        call.enqueue(object : Callback<Company> {
            override fun onResponse(call: Call<Company>, response: Response<Company>) {
                if (response.isSuccessful) {
                    val company: Company = response.body()!!
                    findViewById<TextView>(R.id.title_company).text = company.name

                    findViewById<TextView>(R.id.textView_address).text = company.address
                    findViewById<TextView>(R.id.textView_phone).text = company.phone
                    findViewById<TextView>(R.id.textView_email).text = company.email
                    findViewById<TextView>(R.id.textView_website).text = company.website
                    findViewById<TextView>(R.id.textView_placementsAvailable).text = "Available: " + company.placements_available.toString()
                    findViewById<TextView>(R.id.textView_placementsOcupied).text = "Ocupied: " + company.placements_ocupied.toString()
                }
            }
            override fun onFailure(call: Call<Company>, t: Throwable) {
                Toast.makeText(
                    this@CompaniesInfoActivity,
                    "${R.string.msg_Error} + ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Adicionar marcador da empresa
        mMap.addMarker(MarkerOptions().position(LatLng(latlng.latitude, latlng.longitude)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latlng.latitude, latlng.longitude), 15f))

        // Configurar clique no mapa para abrir em tela cheia
        mMap.setOnMapClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        commentsJob?.cancel() // Cancelar a coleta quando a activity for destruída
    }
}