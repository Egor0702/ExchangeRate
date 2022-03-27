package com.example.exchangerate.data.remote

import com.example.exchangerate.domain.Rates
import com.example.exchangerate.domain.RemoteRepository
import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val request: Request,
    private val service: RetrofitService
): RemoteRepository {
    override fun getRate(): BusLogic<Failure, Rates> =  request.make(service.getInfo()){it.rates}

}