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

class RegisterMahasiswa : AppCompatActivity() {
    private lateinit var masukTextView: TextView
    private lateinit var daftarButton: Button
    private lateinit var dosenButton: Button
    private lateinit var adminButton: Button

    private fun initComponents() {
        masukTextView = findViewById(R.id.masuk)
        daftarButton = findViewById(R.id.daftar)
        dosenButton = findViewById(R.id.dosen)
        adminButton = findViewById(R.id.admin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_mahasiswa)

        initComponents()

        // Fungsi untuk menangani onClick event dari tombol "Masuk"
        masukTextView.setOnClickListener {
            // Pindah ke activity Login
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari tombol "Daftar"
        daftarButton.setOnClickListener {
            // Pindah ke activity RegisterSuccess
            val intent = Intent(this, RegisterSuccess::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari tombol "Dosen"
        dosenButton.setOnClickListener {
            // Pindah ke activity RegisterDosen
            val intent = Intent(this, RegisterDosen::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari tombol "Admin"
        adminButton.setOnClickListener {
            // Pindah ke activity RegisterAdmin
            val intent = Intent(this, RegisterAdmin::class.java)
            startActivity(intent)
        }

    }
}
