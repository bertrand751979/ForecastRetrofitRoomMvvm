package com.example.forecastretrofitroommvvm.activities;

import static com.example.forecastretrofitroommvvm.activities.MainActivity.FORECAST_EXTRA;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.forecastretrofitroommvvm.R;
import com.example.forecastretrofitroommvvm.models.Root;
import com.example.forecastretrofitroommvvm.repositories.RepositoryForecast;

public class ScrollingActivity extends AppCompatActivity {
    private TextView scrDay;
    private TextView scrHight;
    private TextView scrDescription;
    private ImageView scrImage;
    private TextView scrLow;
    private TextView scrSunset;
    private TextView scrSunlight;
    private TextView scrProbRain;
    private Root root;

    private double totalSunrise = 0;
    private double totalSunset = 0;

    private int totSunrise =0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        root = (Root) getIntent().getSerializableExtra(FORECAST_EXTRA);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");


        setViewItem();
    }

    private void setViewItem(){
        scrDay = findViewById(R.id.scr_day);
        scrHight = findViewById(R.id.scr_hight);
        scrDescription =findViewById(R.id.scr_description);
        scrImage = findViewById(R.id.scr_image);
        scrLow = findViewById(R.id.scr_low);
        scrSunset = findViewById(R.id.scr_sunset);
        scrSunlight = findViewById(R.id.scr_sunrise);
        scrProbRain = findViewById(R.id.scr_chance_to_rain);
        scrDay.setText(root.getDay());
        scrHight.setText(String.valueOf(root.getHigh()));
        scrDescription.setText(root.getDescription());
        scrLow.setText(String.valueOf(root.getLow()));
        scrSunset.setText(String.valueOf(root.getSunset()));
        scrSunlight.setText(String.valueOf(root.getSunrise()));
        scrProbRain.setText(String.valueOf(root.getChance_rain()));

        Glide.with(this)
                .load("https://picsum.photos/640/480")
                .into(scrImage);
        //conversion();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();}
        return super.onOptionsItemSelected(item);
    }


    public void conversion(){

        for(Root root: RepositoryForecast.getInstance().forcastList){
             totalSunrise= (root.getSunrise()/3600);
             totSunrise= (int) totalSunrise;
             //totalSunset= Double.valueOf(root.getSunset()/3600);
             //root.setSunset(String.valueOf(totalSunset));
            Log.e("Totset", String.valueOf(totSunrise));

        }
        root.setSunrise(totSunrise);

    }
}
