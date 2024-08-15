package com.example.ces_sheungkit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ces_sheungkit.dao.EnrollmentItemDao
import java.lang.IllegalArgumentException

class EnrollmentViewModelFactory(private val enrollmentItemDao: EnrollmentItemDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EnrollmentViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return EnrollmentViewModel(enrollmentItemDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}