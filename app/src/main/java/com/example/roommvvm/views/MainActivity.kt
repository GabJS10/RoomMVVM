package com.example.roommvvm.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.R
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.viewmodel.PersonViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), UpdateButtonClickInterface, DeleteButtonClickInterface {

    private lateinit var personAdapter: PersonAdapter
    private lateinit var personViewModel: PersonViewModel
    private lateinit var rcView: RecyclerView
    private lateinit var btnAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponents()
        initListeners()
        initAdapter()
        initViewModel()
    }


    private fun initComponents() {
        btnAdd = findViewById(R.id.btnAdd)
        rcView = findViewById(R.id.rcView)
        rcView.setHasFixedSize(true)
        rcView.layoutManager = LinearLayoutManager(this)
    }

    private fun initListeners() {
        btnAdd.setOnClickListener {
            val intent = Intent(this, add_activity::class.java)
            startActivity(intent)
        }
    }

    private fun initViewModel() {
        personViewModel = ViewModelProvider(this).get(PersonViewModel::class.java)
        personViewModel.allPersons.observe(this, Observer { persons ->
            persons?.let { personAdapter.updateList(it) }
        })
    }


    private fun initAdapter() {
        personAdapter = PersonAdapter(this, this, this)
        rcView.adapter = personAdapter
    }

    override fun onUpdateButtonClick(person: Person) {

        val intent = Intent(this, update_activity::class.java)

        intent.putExtra("id", person.id)
        intent.putExtra("name", person.name)
        intent.putExtra("age", person.age)
        intent.putExtra("phone", person.phone)
        intent.putExtra("address", person.address)
        intent.putExtra("city", person.city)
        intent.putExtra("gender", person.gender)
        intent.putExtra("email", person.email)
        intent.putExtra("password", person.password)
        intent.putExtra("photo", person.photo)


        startActivity(intent)
    }

    override fun onDeleteButtonClick(id: Int) {

        personViewModel.deletePersons(id)
    }
}