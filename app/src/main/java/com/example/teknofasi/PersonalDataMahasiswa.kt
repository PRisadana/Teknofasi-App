package com.example.teknofasi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.DatePickerDialog
import android.content.Intent
import android.widget.EditText
import android.widget.ImageView
import java.util.Calendar

class PersonalDataMahasiswa : AppCompatActivity() {
    private lateinit var tanggalmasukEditText: EditText
    private lateinit var panahkananImageView: ImageView
    private lateinit var nimEditText: EditText


    private fun initComponents() {
        tanggalmasukEditText = findViewById(R.id.tanggalMasukEditText)
        panahkananImageView = findViewById(R.id.panahKanan)
        nimEditText = findViewById(R.id.nimEditText)
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
                tanggalmasukEditText.setText(selectedDate)
            }, year, month, dayOfMonth
        )

        datePickerDialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.data_diri_mahasiswa)

        initComponents()

        tanggalmasukEditText.setOnClickListener {
            showDatePickerDialog()
        }

        // Fungsi untuk menangani onClick event dari image "panahKanan"
        panahkananImageView.setOnClickListener {
            val nim = nimEditText.text.toString()

            // Pindah ke activity PersonalDataMahasiswa2
            val intent = Intent(this, PersonalDataMahasiswa2::class.java).apply {
                putExtra("nim", nim)
            }
            startActivity(intent)
        }

    }

}
