package com.example.ipvcconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botão Start para abrir EscolasActivity
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        buttonStart.setOnClickListener {
            val intent = Intent(this, EscolasActivity::class.java)
            startActivity(intent)
        }

        // Botão Maps para abrir MapsActivity
        val buttonMaps = findViewById<Button>(R.id.buttonMaps)
        buttonMaps.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }
}