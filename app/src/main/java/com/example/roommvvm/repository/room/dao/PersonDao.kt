package com.example.roommvvm.repository.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User

@Dao
interface PersonDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: Person): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Transaction
    fun insertPersonAndUser(person: Person, user: User) {
        val personId = insert(person)
        user.person_id = personId.toInt()
        insert(user)
    }

    @Query("SELECT * FROM person")
    fun getAll(): LiveData<List<Person>>

    @Query("SELECT * FROM person WHERE id = :id")
    fun getById(id: Int): LiveData<Person>

    @Query("DELETE FROM person WHERE id = :id")
    fun deleteById(id: Int)

    @Update
    fun update(person: Person)

}