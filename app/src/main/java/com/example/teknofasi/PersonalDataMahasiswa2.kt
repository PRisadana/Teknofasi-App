package com.example.teknofasi

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class PersonalDataMahasiswa2 : AppCompatActivity() {
    private lateinit var panahkiriImageView: ImageView
    private lateinit var selesaiButton: Button
    private lateinit var tanggallahirEditText: EditText

    private lateinit var namaEditText: EditText

    private fun initComponents() {
        panahkiriImageView = findViewById(R.id.panahKiri)
        selesaiButton = findViewById(R.id.selesai)
        tanggallahirEditText = findViewById(R.id.tanggalLahirEditText)

        namaEditText = findViewById(R.id.namaAsliEditText)
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth-${monthOfYear + 1}-$year"
                tanggallahirEditText.setText(selectedDate)
            }, year, month, dayOfMonth
        )

        datePickerDialog.show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.data_diri_mahasiswa_lanjut)

        initComponents()

        tanggallahirEditText.setOnClickListener {
            showDatePickerDialog()
        }

        // Fungsi untuk menangani onClick event dari image "panahKiri"
        panahkiriImageView.setOnClickListener {
            // Pindah ke activity PersonalDataMahasiswa
            val intent = Intent(this, PersonalDataMahasiswa::class.java)
            startActivity(intent)
        }

        // Fungsi untuk menangani onClick event dari button "selesai"
        selesaiButton.setOnClickListener {
            val namaAsli = namaEditText.text.toString()

            // Terima NIM dari PersonalDataMahasiswa
            val nim = intent.getStringExtra("nim")

            // Pindah ke activity RegisterSuccess2
            val intent = Intent(this, RegisterSuccess2::class.java).apply {
                putExtra("nama", namaAsli)
                putExtra("nim", nim)
            }
            startActivity(intent)
        }

    }

}