package com.example.weather_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather_app.R;
import com.example.weather_app.control.GPSTracker;
import com.example.weather_app.control.JsonRequest;
import com.example.weather_app.control.NetworkTracker;
import com.example.weather_app.control.SharedPrefs;
import com.example.weather_app.result.ResultCurrentWeather;
import com.example.weather_app.result.ResultForecastWeather;
import com.example.weather_app.task.CurrentWeatherTask;
import com.example.weather_app.task.ForecastWeatherTask;

import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadTimeNow();
        getTimeLastUpdate();

        loadWeatherSave();
    }
    @Override
    protected void onResume() {
        super.onResume();
        NetworkTracker networkTracker = new NetworkTracker(getApplicationContext());
        boolean checkNetwork = networkTracker.enableNetwork();
        if (checkNetwork){
            Toast.makeText(MainActivity.this, R.string.toast_connected, Toast.LENGTH_LONG).show();
            SharedPrefs.getmInstance().put("time_save", System.currentTimeMillis());
            updateWeatherData();
        } else {
            Toast.makeText(MainActivity.this, R.string.toast_no_connection, Toast.LENGTH_LONG).show();
        }
    }

    private void updateWeatherData() {
        GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
        Location location = gpsTracker.getLocation();
        if (location != null){
            String lat = String.valueOf(location.getLatitude());
            String lon = String.valueOf(location.getLongitude());
            SharedPrefs.getmInstance().put("lat", lat);
            SharedPrefs.getmInstance().put("lon", lon);
            new CurrentWeatherTask(this).execute(JsonRequest.apiCurrentWeatherRequest(lat, lon));
            new ForecastWeatherTask(this).execute(JsonRequest.apiForecastWeatherRequest(lat, lon));
        } else {
            Toast.makeText(MainActivity.this, R.string.toast_gps, Toast.LENGTH_LONG).show();
        }
    }

    private void loadWeatherSave(){
        String check = SharedPrefs.getmInstance().get("check", String.class);
        if (check.equals("checked")){
            String dataCurrent = SharedPrefs.getmInstance().get("current_data", String.class);
            ResultCurrentWeather resultCurrentWeather = new ResultCurrentWeather(this);
            resultCurrentWeather.loadData(dataCurrent);

            String dataForecast = SharedPrefs.getmInstance().get("forecast_data", String.class);
            ResultForecastWeather resultForecastWeather = new ResultForecastWeather(this);
            resultForecastWeather.loadData(dataForecast);
        }
        else {
            Toast.makeText(MainActivity.this, R.string.toast_load_data, Toast.LENGTH_LONG).show();
        }
    }

    private void loadTimeNow(){
        Thread timeNow = new Thread(){
            @Override
            public void run(){
                try {
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView txtTimeNow = findViewById(R.id.tvTimeNow);
                                TextView txtDateNow = findViewById(R.id.tvDateNow);
                                long timeNow = System.currentTimeMillis();
                                DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(getApplicationContext());
                                DateFormat dateFormat = android.text.format.DateFormat.getMediumDateFormat(getApplicationContext());
                                txtTimeNow.setText(timeFormat.format(timeNow));
                                txtDateNow.setText(dateFormat.format(timeNow));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timeNow.start();
    }

    private void getTimeLastUpdate(){
        Thread timeUpdate = new Thread(){
            @Override
            public void run(){
                try {
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView txtLastUpdate = findViewById(R.id.tvLastUpdate);
                                String timeLastUpdate;
                                long timeNow = System.currentTimeMillis();
                                long timeSave = SharedPrefs.getmInstance().get("time_save", Long.class);
                                long time = timeNow - timeSave;

                                long minute = Math.round(time/(60*1000));
                                long hour = Math.round(time/(60*60*1000));
                                long day = Math.round(time/(24*60*60*1000));

                                if (time < 60*1000)
                                    timeLastUpdate = getString(R.string.time_just_finished);
                                else if (time < 60*60*1000)
                                    timeLastUpdate = minute + " " + getString(R.string.time_minutes_ago);
                                else if (time < 24*60*60*1000)
                                    timeLastUpdate = hour + " " + getString(R.string.time_hours_ago);
                                else
                                    timeLastUpdate = day + " " + getString(R.string.time_days_ago);
                                txtLastUpdate.setText(String.format("%s\n%s", getString(R.string.last_update), timeLastUpdate));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timeUpdate.start();
    }
}
