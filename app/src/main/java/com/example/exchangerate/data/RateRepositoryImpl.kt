package com.example.exchangerate.data

import android.util.Log
import com.example.exchangerate.data.remote.BaseResponse
import com.example.exchangerate.domain.RateRepository
import com.example.exchangerate.domain.Rates
import com.example.exchangerate.domain.RemoteRepository
import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import com.example.exchangerate.domain.core.flatMap
import javax.inject.Inject

class RateRepositoryImpl @Inject constructor
    (private val remoteRepository: RemoteRepository): RateRepository {
    override fun getMapRate(): BusLogic<Failure,MutableMap<String,Double>> = remoteRepository.getRate().flatMap{
        Log.d("Egor", "flatMap: ${it.AED}")
        it.getMap()
    }
}