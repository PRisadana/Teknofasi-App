package com.example.teknofasi

import android.os.Bundle
import android.content.Intent
import android.view.View
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    private fun initComponents() {
        loginButton = findViewById(R.id.login)
        registerButton = findViewById(R.id.register)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents()

        // Fungsi untuk menangani onClick event dari tombol "Masuk"
        loginButton.setOnClickListener {
            // Pindah ke activity Login
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari tombol "Buat AKun"
        registerButton.setOnClickListener {
            // Pindah ke activity RegisterMahasiswa
            val intent = Intent(this, RegisterMahasiswa::class.java)
            startActivity(intent)
        }
    }
}
