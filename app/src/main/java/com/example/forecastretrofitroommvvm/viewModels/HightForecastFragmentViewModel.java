package com.example.forecastretrofitroommvvm.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;

import java.util.List;

public class HightForecastFragmentViewModel extends ViewModel {
    private MutableLiveData<List<Root>> myListHighttemperature = new MutableLiveData<>();
    public LiveData<List<Root>> itemHightLiveData = myListHighttemperature;

    public void toPostMyHightItemsList(){
        myListHighttemperature.postValue(RepositoryForecast.getInstance().getForcastList());
    }


}
