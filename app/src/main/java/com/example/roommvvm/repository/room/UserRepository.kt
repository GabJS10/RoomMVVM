package com.example.roommvvm.repository.room

import androidx.lifecycle.LiveData
import com.example.roommvvm.repository.room.dao.UserDao
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User

class UserRepository(private val userDao: UserDao) {

    val allUsers: LiveData<List<User>> = userDao.getAll()

    fun getUser(email: String, password: String): LiveData<User> {
        return userDao.getByEmailAndPassword(email, password)
    }

}