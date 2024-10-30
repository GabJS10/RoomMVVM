package com.example.roommvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roommvvm.repository.room.UserRepository
import com.example.roommvvm.repository.room.database.MyDatabase
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val repository: UserRepository
    val allUsers : LiveData<List<User>>

    init {
        val userDao = MyDatabase.getDatabaseClient(application).userDao()
        repository = UserRepository(userDao)
        allUsers = repository.allUsers
    }

    fun getUser(email: String, password: String): LiveData<User> {
        return repository.getUser(email, password)
    }





}