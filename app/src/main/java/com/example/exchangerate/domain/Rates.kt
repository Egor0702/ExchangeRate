package com.example.exchangerate.domain

import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import com.google.gson.annotations.SerializedName

class Rates (
    val AED: Double,
    var AFN : Double,
    var TRY : Double){

    fun getMap(): BusLogic<Failure, MutableMap<String,Double>> {
        var mapRates = mutableMapOf<String, Double>()
        mapRates.apply {
            put("Дирхам ОАЭ", AED)
            put ("Афганский афгани", AFN)
            put ("Турецкая лира", TRY)

        }
        return BusLogic.Rightable(mapRates)
    }
}