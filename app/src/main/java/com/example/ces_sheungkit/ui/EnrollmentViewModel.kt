package com.example.ces_sheungkit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.ces_sheungkit.dao.EnrollmentItemDao
import com.example.ces_sheungkit.models.EnrollmentItem
import kotlinx.coroutines.launch

class EnrollmentViewModel(private val enrollmentItemDao: EnrollmentItemDao) : ViewModel() {
    val enrollmentItems: LiveData<List<EnrollmentItem>> = enrollmentItemDao.getAllItems().asLiveData()

    fun insertItem(enrollmentItem: EnrollmentItem){
        viewModelScope.launch {
            enrollmentItemDao.insert(enrollmentItem)
        }
    }
}