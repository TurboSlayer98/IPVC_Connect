package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.CourseAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.Course
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmpresasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_empresas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.empresas_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get course ID from intent
        val courseId = intent.getIntExtra("COURSE_ID", -1)
        if (courseId == -1) {
            Toast.makeText(this, "Error: School not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Set up back button
        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            onBackPressed()
        }

        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getCompaniesByCourse(courseId)

        call.enqueue(object : Callback<List<Course>> {
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                if (response.isSuccessful) {
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@EmpresasActivity)
                        adapter = CourseAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                Toast.makeText(
                    this@EmpresasActivity,
                    "Something went wrong ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}