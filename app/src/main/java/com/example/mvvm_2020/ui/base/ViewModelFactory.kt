package com.example.mvvm_2020.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_2020.data.api.ApiHelper
import com.example.mvvm_2020.data.api.ApiServiceFactory
import com.example.mvvm_2020.data.repository.MainRepository
import com.example.mvvm_2020.ui.main.viewmodel.MainViewModel

class ViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(ApiHelper(ApiServiceFactory.createApiService()))) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}