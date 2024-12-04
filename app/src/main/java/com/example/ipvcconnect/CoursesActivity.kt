package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ipvcconnect.adapter.CourseAdapter
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.Course
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cursos)

        // Get school ID from intent
        val schoolId = intent.getIntExtra("SCHOOL_ID", -1)
        if (schoolId == -1) {
            Toast.makeText(this, "Error: School not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Set up back button
        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        loadCourses(schoolId)
    }

    private fun loadCourses(schoolId: Int) {
        val request = ApiClient.buildService(ApiService::class.java)
        val call = request.getCoursesBySchool(schoolId)

        call.enqueue(object : Callback<List<Course>> {
            override fun onResponse(call: Call<List<Course>>, response: Response<List<Course>>) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                if (response.isSuccessful) {
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@CoursesActivity)
                        adapter = CourseAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<List<Course>>, t: Throwable) {
                Toast.makeText(
                    this@CoursesActivity,
                    "Something went wrong ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}