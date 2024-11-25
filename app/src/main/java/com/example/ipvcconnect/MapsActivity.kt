package com.example.ipvcconnect

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
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
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        createLocationCallback()

        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        findViewById<FloatingActionButton>(R.id.zoomInButton).setOnClickListener {
            currentZoom = minOf(currentZoom + 1f, 21f)
            mMap.animateCamera(CameraUpdateFactory.zoomTo(currentZoom))
        }

        findViewById<FloatingActionButton>(R.id.zoomOutButton).setOnClickListener {
            currentZoom = maxOf(currentZoom - 1f, 1f)
            mMap.animateCamera(CameraUpdateFactory.zoomTo(currentZoom))
        }

        findViewById<FloatingActionButton>(R.id.myLocationButton).setOnClickListener {
            requestLocation()
        }

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun requestLocation() {
        if (checkLocationPermission()) {
            try {
                mMap.isMyLocationEnabled = true
                
                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location ->
                        if (location != null) {
                            val currentLatLng = LatLng(location.latitude, location.longitude)
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                        } else {
                            createLocationRequest()
                            fusedLocationClient.requestLocationUpdates(
                                locationRequest,
                                locationCallback,
                                Looper.getMainLooper()
                            )
                        }
                    }
                    .addOnFailureListener { e ->
                        e.printStackTrace()
                    }
            } catch (e: SecurityException) {
                e.printStackTrace()
            }
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_REQUEST_CODE
        )
    }

    private fun checkLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest.create().apply {
            interval = 10000 // 10 segundos
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    private fun createLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val location = locationResult.lastLocation
                if (location != null) {
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                    fusedLocationClient.removeLocationUpdates(locationCallback)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            LOCATION_PERMISSION_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLocation()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        if (::locationCallback.isInitialized) {
            fusedLocationClient.removeLocationUpdates(locationCallback)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        if (checkLocationPermission()) {
            mMap.isMyLocationEnabled = true
            mMap.uiSettings.isMyLocationButtonEnabled = true
        }

        EmpresasData.todasEmpresas.forEach { empresa ->
            val marker = mMap.addMarker(
                MarkerOptions()
                    .position(LatLng(empresa.latitude, empresa.longitude))
                    .title(empresa.nome)
                    .snippet("${empresa.descricao} - ${empresa.curso}")
            )
            marker?.tag = empresa
        }

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

        val vianaDoCastelo = LatLng(41.6946, -8.8362)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vianaDoCastelo, currentZoom))

        mMap.uiSettings.isZoomControlsEnabled = true
    }
} 