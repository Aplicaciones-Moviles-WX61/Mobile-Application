package com.example.nexpartyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToApp = findViewById<Button>(R.id.btnToApp)
        btnToApp.setOnClickListener {
            val activate = Intent(this, CreateAccount::class.java)
            startActivity(activate)
        }

    }
}