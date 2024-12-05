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
    private lateinit var empresaLatLng: LatLng
    private lateinit var database: AppDatabase
    private lateinit var commentDao: CommentsDao
    private var commentsJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_empresa)

        // Inicializar banco de dados
        database = AppDatabase.getDatabase(this)
        commentDao = database.CommentsDao()

        // Get course ID from intent and coordinates
        val companyId = intent.getIntExtra("COMPANY_ID", -1)
        empresaLatLng = LatLng(intent.getDoubleExtra("EMPRESA_LAT", 0.0), intent.getDoubleExtra("EMPRESA_LNG", 0.0))
        val companyPhone = intent.getIntExtra("COMPANY_PHONE", -1)
        val companyEmail = intent.getStringExtra("COMPANY_EMAIL")
        val companyWeb = intent.getStringExtra("COMPANY_WEB")
        if (companyId == -1) {
            Toast.makeText(this, "Error: Company not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Set up back button
        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Configurar mapa
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.miniMapa) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Configurar RecyclerView para comentários
        adapter = CommentsAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.comentariosRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this).apply {
            reverseLayout = true
            stackFromEnd = true
        }
        recyclerView.adapter = adapter

        val commentInput = findViewById<EditText>(R.id.comentarioInput)

        // Adicionar listener para o Enter
        commentInput.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                (event != null && event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN)) {
                val text = commentInput.text.toString()
                if (text.isNotEmpty()) {
                    val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
                    val comment = Comment(null,"Anonymous Comment", text, date, companyId)
                    lifecycleScope.launch {
                        commentDao.insertComment(comment)
                        commentInput.text.clear()
                    }
                }
                true
            } else {
                false
            }
        }

        // Botão de enviar comentário (mantido para quem preferir clicar no botão)
        findViewById<Button>(R.id.enviarComentario).setOnClickListener {
            val text = commentInput.text.toString()
            if (text.isNotEmpty()) {
                val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
                val comment = Comment(null,"Anonymous Comment", text, date, companyId)
                lifecycleScope.launch {
                    commentDao.insertComment(comment)
                    commentInput.text.clear()
                }
            }
        }

        // Cancelar job anterior se existir
        commentsJob?.cancel()

        // Observar comentários em tempo real (em um único lifecycleScope)
        commentsJob = lifecycleScope.launch {
            // Usar distinctUntilChanged para evitar atualizações desnecessárias
            commentDao.getCommentsByCompany(companyId)
                .distinctUntilChanged()
                .collect { comments ->
                    val orderedList = comments
                        .distinctBy { it.id } // Garantir que não há duplicatas
                        .sortedByDescending { it.id }
                    adapter.submitList(orderedList) {
                        // Callback executado após a lista ser atualizada
                        if (orderedList.isNotEmpty()) {
                            recyclerView.smoothScrollToPosition(0)
                        }
                    }
                }
        }

        // Botões de contato
        findViewById<Button>(R.id.buttonLigar).setOnClickListener {
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

        findViewById<Button>(R.id.buttonSite).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(companyWeb))
            startActivity(intent)
        }

        loadCompany(companyId)
    }

    private fun loadCompany(companyId: Int) {
        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getCompany(companyId)

        call.enqueue(object : Callback<Company> {
            override fun onResponse(call: Call<Company>, response: Response<Company>) {
                if (response.isSuccessful) {
                    val company: Company = response.body()!!
                    findViewById<TextView>(R.id.empresaNome).text = company.name
                    findViewById<TextView>(R.id.empresaMorada).text = company.address
                    findViewById<TextView>(R.id.empresaTelefone).text = company.phone
                    findViewById<TextView>(R.id.empresaEmail).text = company.email
                    findViewById<TextView>(R.id.empresaSite).text = company.website
                    findViewById<TextView>(R.id.vagasDisponiveis).text = company.placements_available.toString()
                    findViewById<TextView>(R.id.vagasOcupadas).text = company.placements_ocupied.toString()
                }
            }
            override fun onFailure(call: Call<Company>, t: Throwable) {
                Toast.makeText(
                    this@CompaniesInfoActivity,
                    "Something went wrong ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Adicionar marcador da empresa
        mMap.addMarker(MarkerOptions().position(empresaLatLng))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(empresaLatLng, 15f))

        // Configurar clique no mapa para abrir em tela cheia
        mMap.setOnMapClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            intent.putExtra("EMPRESA_LAT", empresaLatLng.latitude)
            intent.putExtra("EMPRESA_LNG", empresaLatLng.longitude)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        commentsJob?.cancel() // Cancelar a coleta quando a activity for destruída
    }
}