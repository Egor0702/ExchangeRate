package com.example.exchangerate.data.remote

import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {
    const val BASE_URL = "http://api.exchangeratesapi.io/v1/"

    fun makeService(isDebug: Boolean): RetrofitService {
        Log.d("Egor", "ServiceFactory makeService(isDebug: Boolean)")
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor((isDebug))
        )
        val gson = Gson()
        return makeService(okHttpClient, gson)
    }

    private fun makeService(okHttpClient: OkHttpClient, gson: Gson): RetrofitService {
        Log.d("Egor", "ServiceFactory makeService(okHttpClient: OkHttpClient, gson: Gson)")
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create(RetrofitService::class.java)
    }

    private fun makeOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        Log.d("Egor", "ServiceFactory makeOkHttpClient()")
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        Log.d("Egor", "ServiceFactory makeLoggingInterceptor()")
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }
}