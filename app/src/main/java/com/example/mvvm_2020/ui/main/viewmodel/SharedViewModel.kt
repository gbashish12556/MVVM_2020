package com.example.mvvm_2020.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val message = MutableLiveData<String>()

    fun sendMessage(text: String) {
        Thread(Runnable {
            message.postValue(text)
        })
    }
}