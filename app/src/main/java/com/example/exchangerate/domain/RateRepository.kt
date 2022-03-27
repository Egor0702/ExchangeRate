package com.example.exchangerate.domain

import com.example.exchangerate.data.remote.BaseResponse
import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure

interface RateRepository {
    fun getMapRate(): BusLogic<Failure,MutableMap<String,Double>>
}