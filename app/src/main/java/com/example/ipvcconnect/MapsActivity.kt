package com.example.ipvcconnect

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.CompaniesAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.Company
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private var currentZoom = 12f
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    private lateinit var companies: List<Company>

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_maps)

        getCompanies()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        createLocationCallback()

        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener {
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
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnInfoWindowClickListener { marker ->
            val company = marker.tag as? Company
            if (company != null) {
                val intent = Intent(this, CompaniesInfoActivity::class.java)
                intent.putExtra("COMPANY_ID", company.id)
                intent.putExtra("COMPANY_NAME", company.name)
                intent.putExtra("COMPANY_ADDRESS", company.address)
                intent.putExtra("COMPANY_DESCRIPTION", company.description)
                intent.putExtra("COMPANY_AVAILABLE", company.placements_available)
                intent.putExtra("COMPANY_OCUPIED", company.placements_ocupied)
                intent.putExtra("COMPANY_PHONE", company.phone)
                intent.putExtra("COMPANY_EMAIL", company.email)
                intent.putExtra("COMPANY_WEB", company.website)
                intent.putExtra("COMPANY_LAT", company.latitude)
                intent.putExtra("COMPANY_LNG", company.longitude)
                startActivity(intent)
            }
        }
    }

    private fun getCompanies() {
        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getAllCompanies()

        call.enqueue(object : Callback<List<Company>> {
            override fun onResponse(call: Call<List<Company>>, response: Response<List<Company>>) {
                if (response.isSuccessful) {
                    companies = response.body()!!
                    populateMapWithCompanies(companies)
                }
            }

            override fun onFailure(call: Call<List<Company>>, t: Throwable) {
                Toast.makeText(
                    this@MapsActivity,
                    "${R.string.msg_Error} + ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    private fun populateMapWithCompanies(companies: List<Company>) {
        companies.forEach { company ->
            val markerOptions = MarkerOptions()
                .position(LatLng(company.latitude, company.longitude))
                .title(company.name)
                .snippet("${company.placements_available} - ${company.placements_ocupied}")

            val marker = mMap.addMarker(markerOptions)
            marker?.tag = company
        }

        if (companies.isNotEmpty()) {
            val firstCompany = companies[0]
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(firstCompany.latitude, firstCompany.longitude), currentZoom))
        }
    }
} 