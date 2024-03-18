package com.example.navigationcomponent.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationcomponent.Repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    private val mainrepository= MainRepository
    fun getproductdata()
    {
        viewModelScope.launch {
            mainrepository.getproductdata()
        }
    }
}