package com.example.ipvcconnect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class InfoEmpresaActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var comentarios: MutableList<Comentario>
    private lateinit var adapter: ComentariosAdapter
    private lateinit var empresaLatLng: LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info_empresa)

        // Receber dados da empresa
        val empresaNome = intent.getStringExtra("EMPRESA_NOME") ?: "Empresa"
        val empresaMorada = intent.getStringExtra("EMPRESA_MORADA") ?: ""
        val empresaTelefone = intent.getStringExtra("EMPRESA_TELEFONE") ?: ""
        val empresaEmail = intent.getStringExtra("EMPRESA_EMAIL") ?: ""
        val empresaLat = intent.getDoubleExtra("EMPRESA_LAT", 0.0)
        val empresaLng = intent.getDoubleExtra("EMPRESA_LNG", 0.0)
        val vagasDisponiveis = intent.getIntExtra("VAGAS_DISPONIVEIS", 0)
        val vagasOcupadas = intent.getIntExtra("VAGAS_OCUPADAS", 0)
        empresaLatLng = LatLng(empresaLat, empresaLng)

        // Configurar views
        findViewById<TextView>(R.id.empresaNome).text = empresaNome
        findViewById<TextView>(R.id.empresaMorada).text = "Morada: $empresaMorada"
        findViewById<TextView>(R.id.empresaTelefone).text = "Telefone: $empresaTelefone"
        findViewById<TextView>(R.id.empresaEmail).text = "Email: $empresaEmail"
        findViewById<TextView>(R.id.vagasDisponiveis).text = "Vagas Disponíveis: $vagasDisponiveis"
        findViewById<TextView>(R.id.vagasOcupadas).text = "Vagas Ocupadas: $vagasOcupadas"

        // Botão de voltar
        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Configurar mapa
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.miniMapa) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Configurar RecyclerView de comentários
        comentarios = mutableListOf()
        adapter = ComentariosAdapter(comentarios)
        val recyclerView = findViewById<RecyclerView>(R.id.comentariosRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Botão de enviar comentário
        findViewById<Button>(R.id.enviarComentario).setOnClickListener {
            val comentarioInput = findViewById<EditText>(R.id.comentarioInput)
            val texto = comentarioInput.text.toString()
            if (texto.isNotEmpty()) {
                val data = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
                val comentario = Comentario("Comentário Anônimo", texto, data)
                comentarios.add(comentario)
                adapter.notifyItemInserted(comentarios.size - 1)
                comentarioInput.text.clear()
            }
        }

        // Botões de contato
        findViewById<Button>(R.id.buttonLigar).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$empresaTelefone")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonEmail).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$empresaEmail")
            }
            startActivity(intent)
        }

        val empresaSite = intent.getStringExtra("EMPRESA_SITE") ?: ""
        findViewById<TextView>(R.id.empresaSite).text = "Site: $empresaSite"

        findViewById<Button>(R.id.buttonSite).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(empresaSite))
            startActivity(intent)
        }
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
} 