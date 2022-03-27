package com.example.exchangerate.domain.usecase

import com.example.exchangerate.domain.RateRepository
import com.example.exchangerate.domain.Rates
import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import kotlinx.coroutines.*
import javax.inject.Inject

class GetRate @Inject constructor(
    private val rateRepository: RateRepository): UseCase<MutableMap<String,Double>>() {

    override suspend fun run(): BusLogic<Failure, MutableMap<String,Double>> = rateRepository.getMapRate()
}