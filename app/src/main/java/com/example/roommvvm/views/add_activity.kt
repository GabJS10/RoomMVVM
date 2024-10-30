package com.example.roommvvm.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.roommvvm.R
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User
import com.example.roommvvm.viewmodel.PersonViewModel

class add_activity : AppCompatActivity() {

    private lateinit var btnRegister: Button
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etPhone: EditText
    private lateinit var etAddress: EditText
    private lateinit var etCity: EditText
    private lateinit var etGender: EditText
    private lateinit var etEmail: EditText
    private lateinit var tvError: TextView
    private lateinit var etPhoto: EditText

    private lateinit var personViewModel: PersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        personViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        initComponent()
        initListeners()
    }


    private fun initComponent() {
        btnRegister = findViewById(R.id.btn_add)
        etName = findViewById(R.id.et_name)
        etAge = findViewById(R.id.et_age)
        etPhone = findViewById(R.id.et_phone)
        etAddress = findViewById(R.id.et_address)
        etCity = findViewById(R.id.et_city)
        etGender = findViewById(R.id.et_gender)
        etEmail = findViewById(R.id.et_email)
        tvError = findViewById(R.id.tv_error)
        etPhoto = findViewById(R.id.et_photo)
    }
    private fun initListeners() {
        btnRegister.setOnClickListener {
            var strName = etName.text.toString().trim()
            var strAge = etAge.text.toString().trim()
            var strPhone = etPhone.text.toString().trim()
            var strAddress = etAddress.text.toString().trim()
            var strCity = etCity.text.toString().trim()
            var strGender = etGender.text.toString().trim()
            var strEmail = etEmail.text.toString().trim()
            var strPhoto = etPhoto.text.toString().trim()


            if (strName.isEmpty() || strAge.isEmpty() || strPhone.isEmpty() || strAddress.isEmpty() || strCity.isEmpty() || strGender.isEmpty() || strEmail.isEmpty()  || strPhoto.isEmpty()) {
                tvError.text = "Por favor, llene todos los campos"
                return@setOnClickListener
            }

            val person = Person(name = strName, age = strAge.toInt(), phone = strPhone, address = strAddress, city = strCity, gender = strGender, email = strEmail, password = "", photo = strPhoto)

            personViewModel.insertPersons(person)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}