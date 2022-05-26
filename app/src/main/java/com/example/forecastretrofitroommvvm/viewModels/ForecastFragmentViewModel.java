package com.example.forecastretrofitroommvvm.viewModels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;

import java.util.List;

public class ForecastFragmentViewModel extends ViewModel {
        private MutableLiveData<List<Root>> myItemList = new MutableLiveData<>();
        public LiveData<List<Root>> itemLiveData = myItemList;



        public void toPostMyItemsList(){
                myItemList.postValue(RepositoryForecast.getInstance().getForcastList());
        }



}
