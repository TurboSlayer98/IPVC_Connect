package com.example.ipvcconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        // Set up button click listeners
        findViewById<Button>(R.id.btnSchools).setOnClickListener {
            startActivity(Intent(this, EscolasActivity::class.java))
        }
        
        findViewById<Button>(R.id.btnCourses).setOnClickListener {
            startActivity(Intent(this, CursosActivity::class.java))
        }
        
        findViewById<Button>(R.id.btnCompanies).setOnClickListener {
            startActivity(Intent(this, EmpresasActivity::class.java))
        }

        // Set up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}