package com.furkanterzi.retrofitandcompose.repository

import com.furkanterzi.retrofitandcompose.model.User
import com.furkanterzi.retrofitandcompose.remote.RetrofitInstance

class UserRepository {
    suspend fun  getUsers(): List<User> {
        return RetrofitInstance.api.getUsers()
    }
}