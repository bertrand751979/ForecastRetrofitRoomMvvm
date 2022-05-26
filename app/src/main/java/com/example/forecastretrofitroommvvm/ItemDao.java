package com.example.forecastretrofitroommvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.forecastretrofitroommvvm.models.Root;

import java.util.List;

@Dao
public interface ItemDao {
    @Query("SELECT * FROM Root ")
    LiveData<List<Root>> getItems();

    @Insert
    void insertHight(Root root);




}
