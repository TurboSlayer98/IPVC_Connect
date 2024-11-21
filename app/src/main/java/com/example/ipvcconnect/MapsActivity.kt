package com.example.ipvcconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    
    private lateinit var mMap: GoogleMap
    private var currentZoom = 12f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maps)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.maps_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Configurar botões de zoom
        findViewById<FloatingActionButton>(R.id.zoomInButton).setOnClickListener {
            currentZoom += 1f
            mMap.animateCamera(CameraUpdateFactory.zoomTo(currentZoom))
        }

        findViewById<FloatingActionButton>(R.id.zoomOutButton).setOnClickListener {
            currentZoom -= 1f
            mMap.animateCamera(CameraUpdateFactory.zoomTo(currentZoom))
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Adicionar marcadores para todas as empresas
        EmpresasData.todasEmpresas.forEach { empresa ->
            val marker = mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(empresa.latitude, empresa.longitude))
                    .title(empresa.nome)
                    .snippet("${empresa.descricao} - ${empresa.curso}")
            )
            // Guardar a referência da empresa no marcador
            marker?.tag = empresa
        }

        // Configurar clique no marcador para abrir detalhes da empresa
        mMap.setOnInfoWindowClickListener { marker ->
            val empresa = marker.tag as? Empresa
            if (empresa != null) {
                val intent = Intent(this, InfoEmpresaActivity::class.java)
                intent.putExtra("EMPRESA_NOME", empresa.nome)
                intent.putExtra("EMPRESA_MORADA", empresa.morada)
                intent.putExtra("EMPRESA_TELEFONE", empresa.telefone)
                intent.putExtra("EMPRESA_EMAIL", empresa.email)
                intent.putExtra("EMPRESA_LAT", empresa.latitude)
                intent.putExtra("EMPRESA_LNG", empresa.longitude)
                intent.putExtra("VAGAS_DISPONIVEIS", empresa.vagasDisponiveis)
                intent.putExtra("VAGAS_OCUPADAS", empresa.vagasOcupadas)
                startActivity(intent)
            }
        }

        // Centralizar o mapa em Viana do Castelo
        val vianaDoCastelo = LatLng(41.6946, -8.8362)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vianaDoCastelo, currentZoom))

        // Habilitar controles de zoom do mapa
        mMap.uiSettings.isZoomControlsEnabled = true
    }
} 