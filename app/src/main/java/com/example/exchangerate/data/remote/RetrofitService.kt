package com.example.exchangerate.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("latest?access_key=95a4ebb232b13763610a9e49356aecaa&format=1")
    fun getInfo() : Call<BaseResponse>
}