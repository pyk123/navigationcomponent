package com.example.navigationcomponent.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.navigationcomponent.Model.MainRespone
import com.example.navigationcomponent.Retrofit.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


object MainRepository {

    val Productlist=MutableLiveData<MainRespone>()


    suspend fun getproductdata(): MutableLiveData<MainRespone> {

        try {
            val response = withContext(Dispatchers.IO) {
                ApiClient.apiService.getProductList().execute()
            }

            if (response.isSuccessful) {
                val data = response.body()
                Productlist.postValue(data!!)
            } else {
                Log.e("DEBUG", "Failed to fetch data")
            }
        } catch (e: Exception) {
            Log.e("ERROR", "Exception: ${e.message}", e)
        }

        return Productlist
    }


}