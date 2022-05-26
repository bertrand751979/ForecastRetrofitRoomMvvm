package com.example.forecastretrofitroommvvm.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.forecastretrofitroommvvm.MyForecastRetrofitApi;
import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {
    //ON UTILISE Boolean car on a pas besoin de la liste on veut verifier si les données sont
    // reccupérées, pour pouvoir actualiser l'affichage du fragment.
    private MutableLiveData<Boolean> isDataReady= new MutableLiveData<>();
    public LiveData<Boolean> isDataReadyLiveData =isDataReady;


    public void callService(){
        MyForecastRetrofitApi.MyForecastRetrofitService service = MyForecastRetrofitApi.getInstance().getClient().create(MyForecastRetrofitApi.MyForecastRetrofitService.class);
        Call<List<Root>> call= service.getRoots();
        call.enqueue(new Callback<List<Root>>() {
            @Override
            public void onResponse(Call<List<Root>> call, Response<List<Root>> response) {
                saveForcastList(response);
            //    bottomNav.setSelectedItemId(R.id.nav_forecast);
            }
            @Override
            public void onFailure(Call<List<Root>> call, Throwable t) {
            }
        });
    }

    public void saveForcastList(Response<List<Root>> response) {
        if (response.body().size() > 0) {
            RepositoryForecast.getInstance().forcastList = (ArrayList<Root>) response.body();
            isDataReady.postValue(true);
        }
    }



}
