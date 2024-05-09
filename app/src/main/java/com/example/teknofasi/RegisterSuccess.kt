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

class RegisterSuccess : AppCompatActivity() {
    private lateinit var lanjutButton: Button

    private fun initComponents(){
        lanjutButton = findViewById(R.id.lanjutSuccess)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_success)

        initComponents()

        // Fungsi untuk menangani onClick event dari tombol "lanjut"
        lanjutButton.setOnClickListener {
            // Pindah ke activity PersonalDataMahasiswa
            val intent = Intent(this, PersonalDataMahasiswa::class.java)
            startActivity(intent)
        }

    }
}