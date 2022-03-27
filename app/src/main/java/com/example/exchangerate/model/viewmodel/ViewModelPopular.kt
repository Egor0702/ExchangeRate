package com.example.exchangerate.model.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.exchangerate.domain.RateRepository
import com.example.exchangerate.domain.usecase.GetRate
import javax.inject.Inject

class ViewModelPopular @Inject constructor
    (private val getRate: GetRate): BaseViewModel() {

       var mapResponse : MutableLiveData<MutableMap<String, Double>> = MutableLiveData()

    fun getInfoRate() = getRate{it.busLogic(::handleFailure){handleResponse(it)} }

    private fun handleResponse(map:MutableMap<String, Double>){
        Log.d("Egor", "handleResponse ${map.values}")
        mapResponse.value = map
    }

}