package com.example.navigationcomponent.Model

import com.google.gson.annotations.SerializedName

data class MainRespone(

    @SerializedName("products") var products : List<Products>,
    @SerializedName("total") var total : Int,
    @SerializedName("skip") var skip : Int,
    @SerializedName("limit") var limit : Int
)
