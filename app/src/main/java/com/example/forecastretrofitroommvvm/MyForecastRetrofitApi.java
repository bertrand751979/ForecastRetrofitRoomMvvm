package com.example.forecastretrofitroommvvm;




import com.example.forecastretrofitroommvvm.models.Root;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MyForecastRetrofitApi {
    public interface MyForecastRetrofitService{
        @GET("forecast")
        Call<List<Root>> getRoots();
    }

    private final static String BASE_URL="https://5c5c8ba58d018a0014aa1b24.mockapi.io/api/";
    private static MyForecastRetrofitApi INSTANCE = null;
    private MyForecastRetrofitApi(){}
    public static MyForecastRetrofitApi getInstance(){
        if (INSTANCE == null){
            INSTANCE = new MyForecastRetrofitApi();
        }
        return INSTANCE;
    }
    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }


}
