package com.example.ces_sheungkit.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ces_sheungkit.models.EnrollmentItem
import kotlinx.coroutines.flow.Flow

@Dao
interface EnrollmentItemDao {
    @Insert
    suspend fun insert(item: EnrollmentItem)

    @Query("SELECT * FROM enrollment_items")
    fun getAllItems(): Flow<List<EnrollmentItem>>
}