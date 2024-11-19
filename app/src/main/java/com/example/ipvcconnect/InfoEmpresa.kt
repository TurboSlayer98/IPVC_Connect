package com.example.ipvcconnect

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.Button

class InfoEmpresa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info_empresa)

        // Set up back button
        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }

        // Set up call button
        findViewById<Button>(R.id.btnCall).setOnClickListener {
            // Implement phone call functionality
        }

        // Set up email button
        findViewById<Button>(R.id.btnEmail).setOnClickListener {
            // Implement email functionality
        }
    }
}