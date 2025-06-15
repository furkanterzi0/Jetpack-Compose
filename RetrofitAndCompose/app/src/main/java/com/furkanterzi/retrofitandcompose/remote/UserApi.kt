package com.furkanterzi.retrofitandcompose.remote

import com.furkanterzi.retrofitandcompose.model.User
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers() : List<User>
}