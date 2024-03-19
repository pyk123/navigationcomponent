package com.example.navigationcomponent.Roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.navigationcomponent.Model.Products

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProduct(product: MutableList<Products>)

    @Query(value = "Select * from product_table")
    fun getAllBooks() : LiveData<List<Products>>
}