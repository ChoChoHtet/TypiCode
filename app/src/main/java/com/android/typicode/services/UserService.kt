package com.android.typicode.services

import androidx.constraintlayout.motion.utils.ViewState
import com.android.typicode.entity.Users
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getAllUsers(): Response<List<Users>>

//    suspend fun getUser(id: Int): Response<Users>
}