package com.example.ces_sheungkit.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enrollment_items")
data class EnrollmentItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val studentName: String,
    val className: String
)
