package com.example.exchangerate.model

import android.app.Application
import com.example.exchangerate.domain.injection.AppModule
import com.example.exchangerate.domain.injection.DataModule
import com.example.exchangerate.domain.injection.DomainModule
import com.example.exchangerate.domain.injection.ViewModelModule
import com.example.exchangerate.model.activity.BaseActivity
import com.example.exchangerate.model.fragment.PopularFragment
import dagger.Component
import javax.inject.Singleton

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerApp_AppComponent.builder()
            .appModule(AppModule(this)).build()
    }

    @Singleton
    @Component(modules = [AppModule::class, ViewModelModule::class, DomainModule::class, DataModule::class])
    interface AppComponent {
        fun inject (fragment: PopularFragment)
        fun inject(activity: BaseActivity)
    }
}