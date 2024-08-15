package com.example.ces_sheungkit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ces_sheungkit.dao.EnrollmentItemDao
import com.example.ces_sheungkit.models.EnrollmentItem


@Database(entities = [EnrollmentItem::class], version = 1, exportSchema = false)
abstract class EnrollmentDatabase: RoomDatabase(){

    abstract fun enrollmentItemDao(): EnrollmentItemDao

    companion object{
        @Volatile
        private var INSTANCE: EnrollmentDatabase? = null

        fun getDatabase(context: Context): EnrollmentDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EnrollmentDatabase::class.java,
                    "enrollment_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}