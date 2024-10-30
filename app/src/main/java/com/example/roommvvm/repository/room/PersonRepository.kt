package com.example.roommvvm.repository.room

import com.example.roommvvm.repository.room.database.MyDatabase
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roommvvm.repository.room.dao.PersonDao
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User


class PersonRepository(private val personDao: PersonDao)  {



    val allPersons: LiveData<List<Person>> = personDao.getAll()

     fun insert(person: Person, user: User) {
        personDao.insertPersonAndUser(person, user)
    }

     fun insert(person: Person) {
        personDao.insert(person)
    }

     fun update(person: Person) {
        personDao.update(person)
    }

     fun delete(id: Int) {
        personDao.deleteById(id)
    }

    fun getById(id: Int): LiveData<Person> {
        return personDao.getById(id)
    }



}