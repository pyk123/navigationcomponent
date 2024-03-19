package com.example.navigationcomponent.Roomdatabase

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.navigationcomponent.Model.Products
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    companion object
    {
        private  var bdDatabase:database?=null
        fun initaliseDB(context: Context):database?{
            return database.getInstance(context)
        }
        fun insertNotificationdata(context: Context, NotificationList: MutableList<Products>)
        {
            bdDatabase= initaliseDB(context)
            CoroutineScope(Dispatchers.IO).launch { bdDatabase?.getDao()?.saveProduct(NotificationList) }

        }
        fun getalldata(context: Context):LiveData<List<Products>>?
        {
            bdDatabase= initaliseDB(context)
           return bdDatabase?.getDao()?.getAllBooks()
        }


    }
}