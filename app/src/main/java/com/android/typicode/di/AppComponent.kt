package com.android.typicode.di

import android.content.Context
import com.android.typicode.UserApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        ActivityModule::class,
        UserModule::class,
    ]
)
interface AppComponent : AndroidInjector<UserApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: UserApplication): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: UserApplication)
}