package com.example.exchangerate.model.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchangerate.domain.core.Failure

abstract class BaseViewModel : ViewModel() {
    var failureData: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failureData.value = failure
    }

}