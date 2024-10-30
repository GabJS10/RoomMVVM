package com.example.roommvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roommvvm.repository.room.PersonRepository
import com.example.roommvvm.repository.room.database.MyDatabase
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PersonRepository
    val allPersons : LiveData<List<Person>>

    init {
        val personDao = MyDatabase.getDatabaseClient(application).personDao()
        repository = PersonRepository(personDao)
        allPersons = repository.allPersons
    }

    fun insertPersons(person: Person, user: User) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(person, user)
    }

    fun insertPersons(person: Person) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(person)
    }

    fun getById(id: Int): LiveData<Person> {
        return repository.getById(id)
    }

    fun updatePersons(person: Person) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(person)
    }

    fun deletePersons(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(id)
    }


}