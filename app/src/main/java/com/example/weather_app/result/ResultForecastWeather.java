package com.example.weather_app.result;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather_app.R;
import com.example.weather_app.adapter.RecyclerViewAdapter;
import com.example.weather_app.control.Common;
import com.example.weather_app.control.JsonRequest;
import com.example.weather_app.control.SharedPrefs;
import com.example.weather_app.model.DataDetail;
import com.example.weather_app.model.OpenWeatherMap.ForecastWeather;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ResultForecastWeather {
    private Activity activity;
    private ArrayList<DataDetail> dataDetail = new ArrayList<>();

    public ResultForecastWeather(Activity activity) {
        this.activity = activity;
    }

    @SuppressLint("DefaultLocale")
    public void loadData(String sData){
        Gson gson = new Gson();
        Type type = new TypeToken<ForecastWeather>(){}.getType();
        ForecastWeather forecastWeather = gson.fromJson(sData, type);

        int cnt = forecastWeather.getCnt();
        String dCity = forecastWeather.getCity().getName();
        for (int i = 0; i < cnt; i++){
            String dHour = unixTimeToHour(forecastWeather.getList().get(i).getDt());
            String dDate = unixTimeToDate(forecastWeather.getList().get(i).getDt());
            String dTemp = String.format("%.0f", forecastWeather.getList().get(i).getMain().getTemp());
            int idDescription = forecastWeather.getList().get(i).getWeather().get(0).getId();
            String dImgUrl = JsonRequest.getImage(forecastWeather.getList().get(i).getWeather().get(0).getIcon());
            String dHumidity = String.format("%.0f", forecastWeather.getList().get(i).getMain().getHumidity());
            String dPressure = String.format("%.0f", forecastWeather.getList().get(i).getMain().getPressure());
            String dClouds = String.format("%.0f", forecastWeather.getList().get(i).getClouds().getAll());
            String dWindSpeed = String.format("%.1f", forecastWeather.getList().get(i).getWind().getSpeed());
            String dWindType = activity.getString(Common.windType(forecastWeather.getList().get(i).getWind().getDeg()));
            String dWindDirection = activity.getString(Common.windDirection(forecastWeather.getList().get(i).getWind().getDeg()));

            dataDetail.add(new DataDetail(
                    dCity, dHour, dDate, dTemp, idDescription, dImgUrl, dHumidity,
                    dPressure, dClouds, dWindSpeed, dWindType, dWindDirection
            ));
        }
        initRecyclerView();
        SharedPrefs.getmInstance().put("forecast_data", forecastWeather);

    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = activity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(activity, dataDetail);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private String unixTimeToHour(double unixTime){
        DateFormat dateFormat = android.text.format.DateFormat.getTimeFormat(activity.getApplicationContext());
        Date date = new Date();
        date.setTime((long)unixTime*1000);
        return dateFormat.format(date);
    }

    private String unixTimeToDate(double unixTime){
        DateFormat dateFormat = android.text.format.DateFormat.getLongDateFormat(activity.getApplicationContext());
        Date date = new Date();
        date.setTime((long)unixTime*1000);
        return dateFormat.format(date);
    }
}
