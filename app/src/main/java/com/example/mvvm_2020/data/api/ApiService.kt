package com.example.mvvm_2020.data.api

import com.example.mvvm_2020.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}