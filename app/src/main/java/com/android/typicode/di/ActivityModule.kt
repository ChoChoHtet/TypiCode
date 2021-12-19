package com.android.typicode.di

import com.android.typicode.MainActivity
import com.android.typicode.view.UserDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun userDetailActivity(): UserDetailActivity
}