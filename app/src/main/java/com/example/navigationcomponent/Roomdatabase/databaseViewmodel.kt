package com.example.navigationcomponent.Roomdatabase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.navigationcomponent.Model.Products

class databaseViewmodel:ViewModel() {
    fun insertdata(context: Context,products: MutableList<Products>)
    {
        Repository.insertNotificationdata(context,products)
    }
    fun getalldata(context: Context):LiveData<List<Products>>?
    {
        return Repository.getalldata(context)
    }
}