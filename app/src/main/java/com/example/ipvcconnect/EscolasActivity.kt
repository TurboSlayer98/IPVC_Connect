package com.example.ipvcconnect

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.SchoolAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.School
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EscolasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_escolas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.escolas_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getAllSchools()

        call.enqueue(object : Callback<List<School>> {
            override fun onResponse(call: Call<List<School>>, response: Response<List<School>>) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                if (response.isSuccessful) {
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@EscolasActivity)
                        adapter = SchoolAdapter(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<List<School>>, t: Throwable) {
                Toast.makeText(
                    this@EscolasActivity,
                    "Something went wrong ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}