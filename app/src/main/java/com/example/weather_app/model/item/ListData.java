package com.example.weather_app.model.item;

import java.util.List;

public class ListData {
    private double dt;
    private Main main;
    private List<Weather> weather;
    private Clouds clouds;
    private Rain rain;
    private Wind wind;
    private Sys sys;

    public ListData() {
    }

    public ListData(double dt, Main main, List<Weather> weather, Clouds clouds, Rain rain, Wind wind, Sys sys) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.rain = rain;
        this.wind = wind;
        this.sys = sys;
    }

    public double getDt() {
        return dt;
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }
}
