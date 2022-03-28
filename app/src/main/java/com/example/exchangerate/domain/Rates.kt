package com.example.exchangerate.domain

import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import com.google.gson.annotations.SerializedName

class Rates (
    val EUR: Double,
    val USD : Double
    val AED: Double,
    val AFN : Double,
    val TRY : Double,
    val NOK : Double,
    val SEK : Double,
    val AUD : Double,
    val CAD : Double,
    val CHF : Double,
    val CNY : Double,
    val GBP : Double,
    val JPY : Double,
    val BRL : Double,
    val MXN : Double,
    val ISK : Double,
    val GEL : Double,
    val KWD : Double,
    val BHD : Double,
    val KYD : Double,
    val AZN : Double
){

    fun getMap(): BusLogic<Failure, MutableMap<String,Double>> {
        var mapRates = mutableMapOf<String, Double>()
        mapRates.apply {
            put("Евро", EUR)
            put ("Доллар США", USD)
            put("Дирхам ОАЭ", AED)
            put ("Афганский афгани", AFN)
            put ("Турецкая лира", TRY)
            put ("Норвежская крона", NOK)
            put ("Шведская крона", SEK)
            put("Австралийский доллар", AUD)
            put("Канадский доллар", CAD)
            put ("Швейцарский франк", CHF)
            put ("Китайский юань", CNY)
            put("Фунт стерлингов", GBP)
            put ("Иена", JPY)
            put ("Бразильский реал", BRL)
            put ("Мексиканское песо", MXN)
            put ("Исландская крона", ISK)
            put ("Грузинский лари", GEL)
            put ("Кувейтский динар", KWD)
            put ("Бахрейнский динар", BHD)
            put ("Доллар Каймановых островов", KYD)
            put ("Азербайджанский манат", AZN)
        }
        return BusLogic.Rightable(mapRates)
    }
}
