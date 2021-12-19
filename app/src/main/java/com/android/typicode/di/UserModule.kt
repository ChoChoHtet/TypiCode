package com.android.typicode.di

import com.android.typicode.repository.UserRepository
import com.android.typicode.repository.impl.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserModule {
    @Binds
    abstract fun userRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}