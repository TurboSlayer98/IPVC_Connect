package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.SchoolAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.School
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_schools)

        // Set up back button
        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener {
            finish()
        }

        loadSchools()
    }

    private fun loadSchools() {
        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getAllSchools()

        call.enqueue(object : Callback<List<School>> {
            override fun onResponse(call: Call<List<School>>, response: Response<List<School>>) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                if (response.isSuccessful) {
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@SchoolsActivity)
                        adapter = SchoolAdapter(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<List<School>>, t: Throwable) {
                Toast.makeText(
                    this@SchoolsActivity,
                    "${R.string.msg_Error} + ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}