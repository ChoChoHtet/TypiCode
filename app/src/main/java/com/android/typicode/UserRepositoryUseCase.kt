package com.android.typicode

import com.android.typicode.repository.UserRepository
import javax.inject.Inject

class UserRepositoryUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke() = repository.getAllUsers()
}