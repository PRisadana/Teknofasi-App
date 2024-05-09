package com.example.teknofasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 2000 // Waktu tampilan Splash Screen (ms)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen) // Ganti dengan layout yang Anda miliki (screen.xml)

        // Menggunakan Handler untuk menunda pemindahan ke MainActivity
        Handler().postDelayed({
            // Membuat intent untuk memulai MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup SplashActivity agar tidak bisa kembali
        }, SPLASH_TIME_OUT)
    }
}