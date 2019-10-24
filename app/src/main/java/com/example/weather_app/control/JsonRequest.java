package com.example.weather_app.control;

public class JsonRequest {
    private static String API_KEY = "b5a49917b2a2ea747a82f6f74d8d1997";
    private static String units = "metric";

    public static String apiCurrentWeatherRequest(String lat, String lon){
        String API_LINK = "http://api.openweathermap.org/data/2.5/weather";
        return API_LINK + String.format("?lat=%s&lon=%s&APPID=%s&units=%s", lat, lon, API_KEY, units);
    }

    public static String apiForecastWeatherRequest (String lat, String lon){
        String API_LINK = "http://api.openweathermap.org/data/2.5/forecast";
        return API_LINK + String.format("?lat=%s&lon=%s&appid=%s&units=%s", lat, lon, API_KEY, units);
    }

    public static String getImage(String icon){
        return String.format("http://openweathermap.org/img/w/%s.png",icon);
    }
}
