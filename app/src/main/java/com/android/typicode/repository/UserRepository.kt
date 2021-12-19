package com.android.typicode.repository

import com.android.typicode.entity.Users
import com.android.typicode.utils.Result

interface UserRepository {
    suspend fun getAllUsers(): Result<List<Users>>
   // suspend fun getUserDetail(id:Int): Result<Users>
}