package com.example.nexpartyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtCreateAccount = findViewById<TextView>(R.id.txtCreateAccount)
        val btnLoginAccount = findViewById<Button>(R.id.btnLoginAccount)

        txtCreateAccount.setOnClickListener {
            val activate = Intent(this, CreateAccount::class.java)
            startActivity(activate)
        }

        btnLoginAccount.setOnClickListener {
            val activate = Intent(this, CreateEvent::class.java)
            startActivity(activate)
        }

    }
}