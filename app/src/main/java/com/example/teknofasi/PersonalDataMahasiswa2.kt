package com.example.teknofasi

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class PersonalDataMahasiswa2() : AppCompatActivity(), Parcelable {
    private lateinit var panahkiriImageView: ImageView
    private lateinit var selesaiButton: Button
    private lateinit var tanggallahirEditText: EditText
    private lateinit var genderSpinner: Spinner

    private lateinit var namaEditText: EditText

    constructor(parcel: Parcel) : this() {

    }

    private fun initComponents() {
        panahkiriImageView = findViewById(R.id.panahKiri)
        selesaiButton = findViewById(R.id.selesai)
        tanggallahirEditText = findViewById(R.id.tanggalLahirEditText)
        genderSpinner = findViewById(R.id.genderSpinner)

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonalDataMahasiswa2> {
        override fun createFromParcel(parcel: Parcel): PersonalDataMahasiswa2 {
            return PersonalDataMahasiswa2(parcel)
        }

        override fun newArray(size: Int): Array<PersonalDataMahasiswa2?> {
            return arrayOfNulls(size)
        }
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

        // Buat ArrayAdapter menggunakan array gender dan layout default spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Tentukan layout yang akan digunakan saat daftar pilihan muncul
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Terapkan adapter ke spinner
            genderSpinner.adapter = adapter
        }

        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedGender = parent.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@PersonalDataMahasiswa2,
                    "Selected gender: $selectedGender",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }

        }

    }
}