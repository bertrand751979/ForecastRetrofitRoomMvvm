package com.example.forecastretrofitroommvvm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.forecastretrofitroommvvm.viewModels.HightForecastFragmentViewModel;
import com.example.forecastretrofitroommvvm.R;
import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;
import com.example.forecastretrofitroommvvm.adapters.HightForecastAdapter;

import java.util.ArrayList;
import java.util.List;

public class HightForecastFragment extends Fragment {
    private HightForecastAdapter hightForecastAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Root> displayHight = new ArrayList<>();
    private HightForecastFragmentViewModel hightForecastFragmentViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // displayHight = RepositoryForecast.getInstance().hightForcastList;
        //RepositoryForecast.getInstance().ifMoreThanFifteen(RepositoryForecast.getInstance().getHightForcastList());
        displayHight = RepositoryForecast.getInstance().hightForcastList;
        hightForecastFragmentViewModel = new ViewModelProvider(this).get(HightForecastFragmentViewModel.class);
        // RepositoryForecast.getInstance().ifMoreThanFifteen();

    }
    @Override
    public void onResume() {
        super.onResume();
        hightForecastAdapter.setListHight(displayHight);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_forecast_hight, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_forcast_hight);
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        hightForecastAdapter = new HightForecastAdapter();
        recyclerView.setAdapter(hightForecastAdapter);
        hightForecastFragmentViewModel.itemHightLiveData.observe(getViewLifecycleOwner(), new Observer<List<Root>>() {
            @Override
            public void onChanged(List<Root> roots) {
                hightForecastAdapter.setListHight(new ArrayList<>(roots));

            }
        });
    }


}
