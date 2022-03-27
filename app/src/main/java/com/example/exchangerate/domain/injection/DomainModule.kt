package com.example.exchangerate.domain.injection

import com.example.exchangerate.data.RateRepositoryImpl
import com.example.exchangerate.data.remote.RemoteRepositoryImpl
import com.example.exchangerate.data.remote.Request
import com.example.exchangerate.data.remote.RetrofitService
import com.example.exchangerate.domain.RateRepository
import com.example.exchangerate.domain.RemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun getRateRepository (remoteRepository: RemoteRepository) : RateRepository = RateRepositoryImpl(remoteRepository)

    @Provides
    @Singleton
    fun getRemoteRepository (request: Request, service: RetrofitService) : RemoteRepository = RemoteRepositoryImpl(request, service)
}