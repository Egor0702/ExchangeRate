package com.example.exchangerate.domain.injection

import android.content.Context
import android.os.Build
import androidx.viewbinding.BuildConfig
import com.example.exchangerate.data.remote.NetworkHandler
import com.example.exchangerate.data.remote.RetrofitService
import com.example.exchangerate.data.remote.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun getNetworkHandler (context: Context) : NetworkHandler = NetworkHandler(context)

    @Provides
    @Singleton
    fun getRefrofitService() : RetrofitService = ServiceFactory.makeService(BuildConfig.DEBUG)
}