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

class RegisterAdmin : AppCompatActivity() {
    private lateinit var masukTextView: TextView
    private lateinit var dosenButton: Button
    private lateinit var mahasiswaButton: Button

    private fun initComponents() {
        masukTextView = findViewById(R.id.masuk)
        dosenButton = findViewById(R.id.dosen)
        mahasiswaButton = findViewById(R.id.mahasiswa)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_admin)

        initComponents()

        // Fungsi untuk menangani onClick event dari tombol "Masuk"
        masukTextView.setOnClickListener {
            // Pindah ke activity Login
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari tombol "Dosen"
        dosenButton.setOnClickListener {
            // Pindah ke activity RegisterDosen
            val intent = Intent(this, RegisterDosen::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari tombol "Mahasiswa"
        mahasiswaButton.setOnClickListener {
            // Pindah ke activity RegisterMahasiswa
            val intent = Intent(this, RegisterMahasiswa::class.java)
            startActivity(intent)
        }

    }
}
