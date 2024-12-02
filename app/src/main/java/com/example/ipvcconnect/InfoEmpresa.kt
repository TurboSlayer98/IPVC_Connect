package com.example.ipvcconnect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.ipvcconnect.api.ApiClient
import com.example.ipvcconnect.api.ApiService
import com.example.ipvcconnect.models.Company
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info_empresa)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.info_empresas_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get course ID from intent
        val companyId = intent.getIntExtra("COMPANY_ID", -1)
        if (companyId == -1) {
            Toast.makeText(this, "Error: Company not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Set up back button
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
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
                    findViewById<TextView>(R.id.companyName).text = company.name
                    findViewById<TextView>(R.id.companyDescription).text = company.description
                }
            }
            override fun onFailure(call: Call<Company>, t: Throwable) {
                Toast.makeText(
                    this@InfoEmpresa,
                    "Something went wrong ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}