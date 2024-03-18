package com.example.navigationcomponent.Retrofit

import com.example.navigationcomponent.Model.MainRespone
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProductList(): Call<MainRespone>
}