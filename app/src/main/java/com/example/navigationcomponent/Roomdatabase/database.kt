package com.example.navigationcomponent.Roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.navigationcomponent.Model.Products


@Database(entities = [Products::class], version = 1)
abstract class database: RoomDatabase() {
    abstract fun  getDao(): RoomDao
    companion object{
        private const val DATABASE_NAME="UserDatabase"

        var instance:database?=null

        fun getInstance(context: Context):database?{
            if(instance==null){
                synchronized(database::class.java)
                {
                    if(instance==null){
                        instance= Room.databaseBuilder(context,database::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }
            return instance
        }
    }

}