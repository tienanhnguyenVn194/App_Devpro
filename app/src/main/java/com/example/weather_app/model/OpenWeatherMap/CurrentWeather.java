package com.example.weather_app.model.OpenWeatherMap;

import com.example.weather_app.model.item.Clouds;
import com.example.weather_app.model.item.Coord;
import com.example.weather_app.model.item.Main;
import com.example.weather_app.model.item.Sys;
import com.example.weather_app.model.item.Weather;
import com.example.weather_app.model.item.Wind;

import java.util.List;

public class CurrentWeather {
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Sys sys;
    private String name;

    public CurrentWeather() {
    }

    public CurrentWeather(Coord coord, List<Weather> weather, Main main, Wind wind, Clouds clouds, Sys sys, String name) {
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.sys = sys;
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
