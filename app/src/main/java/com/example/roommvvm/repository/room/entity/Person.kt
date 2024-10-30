package com.example.roommvvm.repository.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")

data class Person (


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,


    @ColumnInfo(name = "name")
    var name: String = "",


    @ColumnInfo(name = "age")
    var age: Int = 0,

    @ColumnInfo(name = "phone")
    var phone: String = "",

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "city")
    var city: String = "",

    @ColumnInfo(name = "gender")
    var gender: String = "",


   @ColumnInfo(name = "email")
    var email: String = "",

    @ColumnInfo(name = "password")
    var password: String? = "",

    @ColumnInfo(name = "photo")
    val photo: String? = "",

)