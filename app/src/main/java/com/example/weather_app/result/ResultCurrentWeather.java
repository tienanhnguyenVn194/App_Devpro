package com.example.weather_app.result;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.TextView;

import com.example.weather_app.R;
import com.example.weather_app.control.Common;
import com.example.weather_app.control.DataDescription;
import com.example.weather_app.control.JsonRequest;
import com.example.weather_app.control.SharedPrefs;
import com.example.weather_app.model.OpenWeatherMap.CurrentWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultCurrentWeather {
    private Activity activity;
    private TextView txtCity, txtTemp, txtDescription, txtHumidity, txtPressure, txtClouds,
            txtWind, txtSunrise, txtSunset;
    private CircleImageView imgIcon;

    public ResultCurrentWeather(Activity activity) {
        this.activity = activity;
    }

    @SuppressLint("DefaultLocale")
    public void loadData(String data){
        initWidget();
        Gson gson = new Gson();
        Type type = new TypeToken<CurrentWeather>(){}.getType();
        CurrentWeather currentWeather = gson.fromJson(data, type);

        txtCity.setText(String.format("%s, %s",
                currentWeather.getName(),
                currentWeather.getSys().getCountry()));
        txtTemp.setText(String.format("%.0f%s",
                currentWeather.getMain().getTemp(),
                activity.getString(R.string.celsius)));
        txtDescription.setText(activity.getString(DataDescription.idDescription(currentWeather.getWeather().get(0).getId())));
        txtHumidity.setText(String.format("%s %.0f %s",
                activity.getString(R.string.humidity),
                currentWeather.getMain().getHumidity(),
                activity.getString(R.string.percent)));
        txtPressure.setText(String.format("%s %.0f %s",
                activity.getString(R.string.pressure),
                currentWeather.getMain().getPressure(),
                activity.getString(R.string.hPa)));
        txtClouds.setText(String.format("%s %.0f %s",
                activity.getString(R.string.cloudiness),
                currentWeather.getClouds().getAll(),
                activity.getString(R.string.percent)));
        txtWind.setText(String.format("%s %.1f %s \n        %s \n        %s",
                activity.getString(R.string.wind),
                currentWeather.getWind().getSpeed(),
                activity.getString(R.string.wind_speed_ms),
                activity.getString(Common.windType(currentWeather.getWind().getSpeed())),
                activity.getString(Common.windDirection(currentWeather.getWind().getDeg()))
        ));
        txtSunrise.setText(String.format("%s %s",
                activity.getString(R.string.sunrise),
                unixTimeToTime(currentWeather.getSys().getSunrise())));
        txtSunset.setText(String.format("%s %s",
                activity.getString(R.string.sunset),
                unixTimeToTime(currentWeather.getSys().getSunset())));
        Picasso.get().load(JsonRequest.getImage(currentWeather.getWeather().get(0).getIcon())).into(imgIcon);

        SharedPrefs.getmInstance().put("current_data", currentWeather);
        SharedPrefs.getmInstance().put("check", "checked");
    }

    private void initWidget() {
        txtCity = activity.findViewById(R.id.tvCity);
        txtTemp = activity.findViewById(R.id.tvTemp);
        txtDescription = activity.findViewById(R.id.tvDescription);
        txtHumidity = activity.findViewById(R.id.tvHumidity);
        txtPressure = activity.findViewById(R.id.tvPressure);
        txtClouds = activity.findViewById(R.id.tvClouds);
        txtWind = activity.findViewById(R.id.tvWind);
        txtSunrise = activity.findViewById(R.id.tvSunrise);
        txtSunset = activity.findViewById(R.id.tvSunset);
        imgIcon = activity.findViewById(R.id.ivIcon);
    }

    private String unixTimeToTime(double unixTime){
        DateFormat dateFormat = android.text.format.DateFormat.getTimeFormat(activity.getApplicationContext());
        Date date = new Date();
        date.setTime((long)unixTime*1000);
        return dateFormat.format(date);
    }
}
