package com.example.forecastretrofitroommvvm.viewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.forecastretrofitroommvvm.OnItemClickedGoToDescription;
import com.example.forecastretrofitroommvvm.R;
import com.example.forecastretrofitroommvvm.models.Root;

public class HightForecastViewHolder extends RecyclerView.ViewHolder {
    private TextView vhHightDay;
    private TextView vhHightDescription;
    private TextView vhHightHight;
    private TextView vhHightLow;
    private ImageView vhHightImage;

    public HightForecastViewHolder(@NonNull View view) {
        super(view);
        vhHightDay = view.findViewById(R.id.raw_hight_day);
        vhHightDescription = view.findViewById(R.id.raw_hight_description);
        vhHightHight = view.findViewById(R.id.raw_hight_hight);
        vhHightLow = view.findViewById(R.id.raw_hight_low);
        vhHightImage = view.findViewById(R.id.raw_hight_picture);
    }

    public TextView getVhHightDay() {
        return vhHightDay;
    }

    public void setVhHightDay(TextView vhHightDay) {
        this.vhHightDay = vhHightDay;
    }

    public TextView getVhHightDescription() {
        return vhHightDescription;
    }

    public void setVhHightDescription(TextView vhHightDescription) {
        this.vhHightDescription = vhHightDescription;
    }

    public TextView getVhHightHight() {
        return vhHightHight;
    }

    public void setVhHightHight(TextView vhHightHight) {
        this.vhHightHight = vhHightHight;
    }

    public TextView getVhHightLow() {
        return vhHightLow;
    }

    public void setVhHightLow(TextView vhHightLow) {
        this.vhHightLow = vhHightLow;
    }

    public ImageView getVhHightImage() {
        return vhHightImage;
    }

    public void setVhHightImage(ImageView vhHightImage) {
        this.vhHightImage = vhHightImage;
    }

    public void bind (Root root){
        vhHightDay.setText(root.getDay());
        vhHightDescription.setText(root.getDescription());
        vhHightHight.setText(String.valueOf(root.getHigh()));
        vhHightLow.setText(String.valueOf(root.getLow()));
        Glide.with(vhHightImage.getContext())
                .load(root.getImage())
                .into(vhHightImage);
    }
}
