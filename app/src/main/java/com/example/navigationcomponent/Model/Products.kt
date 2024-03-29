package com.example.navigationcomponent.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "product_table")
data class Products(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id : Int,
    @SerializedName("title") var title : String,
    @SerializedName("description") var description : String,
    @SerializedName("price") var price : Int,
    @SerializedName("discountPercentage") var discountPercentage : Double,
    @SerializedName("rating") var rating : Double,
    @SerializedName("stock") var stock : Int,
    @SerializedName("brand") var brand : String,
    @SerializedName("category") var category : String,
    @SerializedName("thumbnail") var thumbnail : String
)
