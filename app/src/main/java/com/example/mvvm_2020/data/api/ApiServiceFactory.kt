package com.example.mvvm_2020.data.api

class ApiServiceFactory {
    companion object{
        fun createApiService():ApiService{
            return ApiServiceImpl()
        }
    }
}