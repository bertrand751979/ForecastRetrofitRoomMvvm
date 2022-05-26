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
import org.w3c.dom.Text;

public class ForecastViewHolder extends RecyclerView.ViewHolder {
    private TextView vhDay;
    private TextView vhDescription;
    private TextView vhHigh;
    private TextView vhLow;
    private ImageView vhImage;
    private LinearLayout vhLinear;

    public ForecastViewHolder(@NonNull View view) {
        super(view);
        vhDay = view.findViewById(R.id.raw_day);
        vhDescription = view.findViewById(R.id.raw_description);
        vhHigh = view.findViewById(R.id.raw_hight);
        vhLow = view.findViewById(R.id.raw_low);
        vhImage = view.findViewById(R.id.raw_picture);
        vhLinear = view.findViewById(R.id.linearDescription);
    }

    public TextView getVhDay() {
        return vhDay;
    }

    public void setVhDay(TextView vhDay) {
        this.vhDay = vhDay;
    }

    public TextView getVhDescription() {
        return vhDescription;
    }

    public void setVhDescription(TextView vhDescription) {
        this.vhDescription = vhDescription;
    }


   public TextView getVhHigh() {
        return vhHigh;
    }

    public void setVhHigh(TextView vhHigh) {
        this.vhHigh = vhHigh;
    }

    public TextView getVhLow() {
        return vhLow;
    }

    public void setVhLow(TextView vhLow) {
        this.vhLow = vhLow;
    }

    public ImageView getVhImage() {
        return vhImage;
    }

    public void setVhImage(ImageView vhImage) {
        this.vhImage = vhImage;
    }

    public LinearLayout getVhLinear() {
        return vhLinear;
    }

    public void setVhLinear(LinearLayout vhLinear) {
        this.vhLinear = vhLinear;
    }

    public void bind (Root root, OnItemClickedGoToDescription onItemClickedGoToDescription){
        vhDay.setText(root.getDay());
        vhDescription.setText(root.getDescription());
        vhHigh.setText(String.valueOf(root.getHigh()));
        vhLow.setText(String.valueOf(root.getLow()));
        Glide.with(vhImage.getContext())
                .load(root.getImage())
                .into(vhImage);

        vhLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickedGoToDescription.goToDescrition(root);
            }
        });
    }
}
