package com.example.weather_app.model.OpenWeatherMap;

import com.example.weather_app.model.item.City;
import com.example.weather_app.model.item.ListData;

import java.util.List;

public class ForecastWeather {
    private int cnt;
    private List<ListData> list;
    private City city;

    public ForecastWeather() {
    }

    public ForecastWeather(int cnt, List<ListData> list, City city) {
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<ListData> getList() {
        return list;
    }

    public void setList(List<ListData> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
