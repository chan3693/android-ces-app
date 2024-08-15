package com.example.ces_sheungkit.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ces_sheungkit.dao.EnrollmentItemDao

@Database(entities = [EnrollmentItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun enrollmentItemDao(): EnrollmentItemDao
}