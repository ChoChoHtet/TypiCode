package com.android.typicode

import com.android.typicode.di.DaggerAppComponent
import dagger.android.support.DaggerApplication

class UserApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        applicationInjector().inject(this)
    }

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()
}