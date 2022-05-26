package com.example.forecastretrofitroommvvm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.forecastretrofitroommvvm.OnItemClickedGoToDescription;
import com.example.forecastretrofitroommvvm.R;
import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.viewHolders.ForecastViewHolder;
import com.example.forecastretrofitroommvvm.viewHolders.HightForecastViewHolder;

import java.util.ArrayList;

public class HightForecastAdapter extends RecyclerView.Adapter<HightForecastViewHolder> {
    private ArrayList<Root> listHight = new ArrayList<>() ;

    public HightForecastAdapter() {

    }

    public void setListHight(ArrayList<Root> listHight) {
        this.listHight = listHight;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public HightForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_hight_forecast,parent,false);
        return new HightForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HightForecastViewHolder holder, int position) {
        holder.bind(listHight.get(position));

    }

    @Override
    public int getItemCount() {
        return listHight.size();
    }

}
