package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.CompaniesAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.Company
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompaniesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_companies)

        // Get course ID from intent
        val courseId = intent.getIntExtra("COURSE_ID", -1)
        if (courseId == -1) {
            Toast.makeText(this, "${R.string.msg_error_course}", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Set up back button
        findViewById<ImageButton>(R.id.buttonBack).setOnClickListener {
            finish()
        }

        loadCompanies(courseId)
    }

    private fun loadCompanies(courseId: Int) {
        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getCompaniesByCourse(courseId)

        call.enqueue(object : Callback<List<Company>> {
            override fun onResponse(call: Call<List<Company>>, response: Response<List<Company>>) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                if (response.isSuccessful) {
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@CompaniesActivity)
                        adapter = CompaniesAdapter(response.body()!!)
                    }
                }
            }
            override fun onFailure(call: Call<List<Company>>, t: Throwable) {
                Toast.makeText(
                    this@CompaniesActivity,
                    "${R.string.msg_Error} + ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}