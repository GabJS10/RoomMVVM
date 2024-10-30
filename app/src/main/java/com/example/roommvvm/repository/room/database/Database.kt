package com.example.roommvvm.repository.room.database

import android.content.Context
import androidx.room.*
import androidx.room.Database
import com.example.roommvvm.repository.room.dao.PersonDao
import com.example.roommvvm.repository.room.dao.UserDao
import com.example.roommvvm.repository.room.entity.Person
import com.example.roommvvm.repository.room.entity.User


@Database(entities = [Person::class, User::class], version = 3, exportSchema = true)
abstract class MyDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao
    abstract fun userDao(): UserDao


    companion object {

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabaseClient(context: Context) : MyDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, MyDatabase::class.java, "MYDATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }


}