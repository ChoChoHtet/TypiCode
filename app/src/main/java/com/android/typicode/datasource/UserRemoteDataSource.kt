package com.android.typicode.datasource

import com.android.typicode.services.UserService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
    private val userService: UserService
) : BaseDataSource() {
    suspend fun getAllUsers() = getResult {
        userService.getAllUsers()
    }
//    suspend fun getUsers(id:Int)= getResult {
//        userService.getUser(id)
//    }
}