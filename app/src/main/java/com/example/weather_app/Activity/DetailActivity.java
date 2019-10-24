package com.example.weather_app.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.weather_app.R;
import com.example.weather_app.control.DataDescription;
import com.example.weather_app.model.DataDetail;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    TextView txtDCity, txtDDescription, txtDTemp, txtDHumidity, txtDPressure, txtDClouds, txtDWind, txtDHour, txtDDate;
    CircleImageView imgDIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initWidget();
        DataDetail data = (DataDetail) getIntent().getSerializableExtra("data_detail");

        txtDCity.setText(data.getdCity());
        txtDDescription.setText(DataDescription.idDescription(data.getId()));
        txtDTemp.setText(String.format("%s%s", data.getdTemp(), getString(R.string.celsius)));
        txtDHumidity.setText(String.format("%s %s %s",
                getString(R.string.humidity),
                data.getdHumidity(),
                getString(R.string.percent)));
        txtDPressure.setText(String.format("%s %s %s ",
                getString(R.string.pressure),
                data.getdPressure(),
                getString(R.string.hPa)));
        txtDClouds.setText(String.format("%s %s %s",
                getString(R.string.cloudiness),
                data.getdClouds(),
                getString(R.string.percent)));
        txtDWind.setText(String.format("%s %s %s \n        %s \n        %s",
                getString(R.string.wind),
                data.getdWindSpeed(),
                getString(R.string.wind_speed_ms),
                data.getdWindType(),
                data.getdWindDirection()
        ));
        txtDHour.setText(data.getdHour());
        txtDDate.setText(data.getdDate());
        Picasso.get().load(data.getdImgUrl()).into(imgDIcon);
    }

    private void initWidget() {
        txtDCity = findViewById(R.id.tvCityD);
        txtDTemp = findViewById(R.id.tvTempD);
        txtDDescription = findViewById(R.id.tvDescriptionD);
        txtDHumidity = findViewById(R.id.tvHumidityD);
        txtDPressure = findViewById(R.id.tvPressureD);
        txtDClouds = findViewById(R.id.tvCloudsD);
        txtDWind = findViewById(R.id.tvWindD);
        txtDHour = findViewById(R.id.tvHourD);
        txtDDate = findViewById(R.id.tvDateD);

        imgDIcon = findViewById(R.id.ivIconD);
    }
}

