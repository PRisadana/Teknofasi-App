package com.example.teknofasi

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterSuccess2 : AppCompatActivity() {
    private lateinit var namaTextView: TextView
    private lateinit var nimTextView: TextView

    private fun initComponents() {
        namaTextView = findViewById(R.id.namaTextView)
        nimTextView = findViewById(R.id.nimTextView)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.register_success2)

        initComponents()

        //menampilkan inputan dari activity PersonalDataMahasiswa dan PersonalDataMahasiswa2
        val namaAsli = intent.getStringExtra("nama")
        val nim = intent.getStringExtra("nim")

        namaTextView.text = namaAsli
        nimTextView.text = nim

    }
}