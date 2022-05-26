package com.example.forecastretrofitroommvvm.fragments;

import static com.example.forecastretrofitroommvvm.activities.MainActivity.FORECAST_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.forecastretrofitroommvvm.viewModels.ForecastFragmentViewModel;
import com.example.forecastretrofitroommvvm.OnItemClickedGoToDescription;
import com.example.forecastretrofitroommvvm.R;
import com.example.forecastretrofitroommvvm.activities.ScrollingActivity;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;
import com.example.forecastretrofitroommvvm.adapters.ForecastAdapter;
import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.viewModels.MainActivityViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ForecastFragment extends Fragment {
    private ForecastAdapter forecastAdapter;
    private RecyclerView recyclerView;
    public ForecastFragmentViewModel forecastFragmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forecastFragmentViewModel = new ViewModelProvider(this).get(ForecastFragmentViewModel.class);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_forcast, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewForcast);


        setViewItem();
        RepositoryForecast.getInstance().ifMoreThanFifteen(RepositoryForecast.getInstance().hightForcastList);
    }


    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnItemClickedGoToDescription onItemClickedGoToDescription = new OnItemClickedGoToDescription() {
            @Override
            public void goToDescrition(Root root) {
                Intent intent = new Intent(ForecastFragment.this.getContext(), ScrollingActivity.class);
                intent.putExtra(FORECAST_EXTRA,root);
                startActivity(intent);
                Toast.makeText(ForecastFragment.this.getContext(), "Vers descriptif", Toast.LENGTH_SHORT).show();
            }
        };


        forecastAdapter = new ForecastAdapter(onItemClickedGoToDescription);
        recyclerView.setAdapter(forecastAdapter);
        forecastFragmentViewModel.itemLiveData.observe(getViewLifecycleOwner(), new Observer<List<Root>>() {
            @Override
            public void onChanged(List<Root> roots) {
                forecastAdapter.setListAdapter(new ArrayList<>(roots));
            }
        });
        forecastFragmentViewModel.toPostMyItemsList();
    }

}
