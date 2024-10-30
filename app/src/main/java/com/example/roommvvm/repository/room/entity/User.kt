package com.example.roommvvm.repository.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "user",
    foreignKeys = [
        ForeignKey(
            entity = Person::class,
            parentColumns = ["id"],
            childColumns = ["person_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )]
    )
data class User (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "person_id")
    var person_id: Int = 0,

    @ColumnInfo(name = "username")
    var username: String? = "",

    @ColumnInfo(name = "password")
    var password: String = "",

    @ColumnInfo(name = "email")
    var email: String = ""


)