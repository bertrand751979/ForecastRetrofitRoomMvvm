package com.example.forecastretrofitroommvvm.repositories;

import com.example.forecastretrofitroommvvm.MyForecastRetrofitApi;
import com.example.forecastretrofitroommvvm.models.Root;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepositoryForecast {

    public ArrayList<Root> forcastList = new ArrayList<>();
    public ArrayList<Root> hightForcastList = new ArrayList<>();

    private RepositoryForecast(){}
    private static RepositoryForecast INSTANCE = null;
    public static RepositoryForecast getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RepositoryForecast();
        }
        return INSTANCE;
    }

    public ArrayList<Root> getForcastList() {
        return forcastList;
    }

    public void setForcastList(ArrayList<Root> forcastList) {
        this.forcastList = forcastList;
    }

    public ArrayList<Root> getHightForcastList() {
        return hightForcastList;
    }

    public void setHightForcastList(ArrayList<Root> hightForcastList) {
        this.hightForcastList = hightForcastList;
    }

    public ArrayList ifMoreThanFifteen(ArrayList<Root>listSort){
        for(Root root:forcastList){
            if (root.getHigh()>15){
                listSort.add(root);
            }
        }
        return listSort;
    }

    public void add(Root root){
        hightForcastList.add(root);
    }



}
