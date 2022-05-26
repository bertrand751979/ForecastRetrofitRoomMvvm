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
import java.util.ArrayList;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    private ArrayList<Root> listBookAdapter = new ArrayList<>();
    private OnItemClickedGoToDescription onItemClickedGoToDescription;

    public ForecastAdapter(OnItemClickedGoToDescription onItemClickedGoToDescription) {
        //this.list = list;
        this.onItemClickedGoToDescription = onItemClickedGoToDescription;
    }

    public void setListAdapter(ArrayList<Root> listBookAdapter) {
        this.listBookAdapter = listBookAdapter;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.raw_forecast,parent,false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        holder.bind(listBookAdapter.get(position),onItemClickedGoToDescription);
    }

    @Override
    public int getItemCount() {
        return listBookAdapter.size();
    }
}
