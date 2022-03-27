package com.example.exchangerate.data.remote

import android.util.Log
import com.example.exchangerate.domain.core.BusLogic
import com.example.exchangerate.domain.core.Failure
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Request @Inject constructor(private val networkHandler: NetworkHandler) {
    init {
        Log.d("Egor", "Всем хло мы в Request")
    }

    fun <T : BaseResponse, R> make(call: Call<T>, transform: (T) -> R): BusLogic<Failure, R> {
        Log.d("Egor", "Request make(). Is network: ${networkHandler.isConnected}")
        return when (networkHandler.isConnected) {
            true -> execute(call, transform)
            false, null -> BusLogic.Failed(Failure.NetworkConnectionError)
        }
    }

    private fun <T : BaseResponse, R> execute(call: Call<T>, transform: (T) -> R): BusLogic<Failure, R> {
        Log.d("Egor", "Request execute()")
        return try {
            Log.d("Egor", "Мы в execute")
            val response = call.execute()
            when (response.isSucceed()) {
                true -> BusLogic.Rightable(transform((response.body()!!)))
                false -> BusLogic.Failed(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Log.d("Egor", "${exception.message}")
            BusLogic.Failed(Failure.ServerError)
        }
    }

    fun <T : BaseResponse> Response<T>.isSucceed(): Boolean {
        Log.d("Egor", "Request isSucceed()")
        return isSuccessful && body() != null
    }
}