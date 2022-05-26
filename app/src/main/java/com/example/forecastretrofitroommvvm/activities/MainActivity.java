package com.example.forecastretrofitroommvvm.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.forecastretrofitroommvvm.MyForecastRetrofitApi;
import com.example.forecastretrofitroommvvm.R;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;
import com.example.forecastretrofitroommvvm.fragments.ForecastFragment;
import com.example.forecastretrofitroommvvm.fragments.HightForecastFragment;
import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.viewModels.MainActivityViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    public static String FORECAST_EXTRA = "forecast_extra";
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        setContentView(R.layout.activity_main);
        bottomNav =findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ForecastFragment()).commit();
        mainActivityViewModel.isDataReadyLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                //si on a reccupéré les données alors on peut afficher le fragment
                if(aBoolean==true){
                    bottomNav.setSelectedItemId(R.id.nav_forecast);
                }
            }
        });
        mainActivityViewModel.callService();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNav.setSelectedItemId(R.id.nav_forecast);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_forecast:
                    selectedFragment = new ForecastFragment();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.nav_hight_forecast:
                    selectedFragment = new HightForecastFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };


}