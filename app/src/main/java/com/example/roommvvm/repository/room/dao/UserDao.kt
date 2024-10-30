package com.example.roommvvm.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.roommvvm.repository.room.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>


    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun getByEmailAndPassword(email: String, password: String): LiveData<User>
}