package com.example.weather_app.task;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;

import com.example.weather_app.control.Helper;
import com.example.weather_app.result.ResultCurrentWeather;


public class CurrentWeatherTask extends AsyncTask<String, Void, String> {

    @SuppressLint("StaticFieldLeak")
    private Activity activity;

    public CurrentWeatherTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String stream;
        String urlString = strings[0];
        Helper http = new Helper();
        stream = http.getHttpData(urlString);
        return stream;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.contains("Error: Not found city")){
            return;
        }
        ResultCurrentWeather resultCurrentWeather = new ResultCurrentWeather(activity);
        resultCurrentWeather.loadData(s);
    }
}
