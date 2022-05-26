package com.example.forecastretrofitroommvvm;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.forecastretrofitroommvvm.models.Root;


@Database(entities = {Root.class},version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase INSTANCE;
    public abstract ItemDao getItemDao();
    public static synchronized ApplicationDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ApplicationDatabase.class, "volumeInfo_app").build();
        }
        return INSTANCE;
    }
}
