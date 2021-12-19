package com.android.typicode.repository.impl

import com.android.typicode.datasource.UserRemoteDataSource
import com.android.typicode.entity.Users
import com.android.typicode.repository.UserRepository
import com.android.typicode.utils.Result
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getAllUsers(): Result<List<Users>> {
        return userRemoteDataSource.getAllUsers()
    }

//    override suspend fun getUserDetail(id: Int): Result<Users> {
//        return userRemoteDataSource.getUsers(id)
//    }
}