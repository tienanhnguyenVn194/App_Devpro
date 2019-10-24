package com.example.weather_app.model;

public class DataDetail {
    private String dCity;
    private String dHour;
    private String dDate;
    private String dTemp;
    private int id;
    private String dImgUrl;
    private String dHumidity;
    private String dPressure;
    private String dClouds;
    private String dWindSpeed;
    private String dWindType;
    private String dWindDirection;

    public DataDetail() {
    }

    public DataDetail(String dCity, String dHour, String dDate, String dTemp, int id, String dImgUrl, String dHumidity, String dPressure, String dClouds, String dWindSpeed, String dWindType, String dWindDirection) {
        this.dCity = dCity;
        this.dHour = dHour;
        this.dDate = dDate;
        this.dTemp = dTemp;
        this.id = id;
        this.dImgUrl = dImgUrl;
        this.dHumidity = dHumidity;
        this.dPressure = dPressure;
        this.dClouds = dClouds;
        this.dWindSpeed = dWindSpeed;
        this.dWindType = dWindType;
        this.dWindDirection = dWindDirection;
    }

    public String getdCity() {
        return dCity;
    }

    public void setdCity(String dCity) {
        this.dCity = dCity;
    }

    public String getdHour() {
        return dHour;
    }

    public void setdHour(String dHour) {
        this.dHour = dHour;
    }

    public String getdDate() {
        return dDate;
    }

    public void setdDate(String dDate) {
        this.dDate = dDate;
    }

    public String getdTemp() {
        return dTemp;
    }

    public void setdTemp(String dTemp) {
        this.dTemp = dTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdImgUrl() {
        return dImgUrl;
    }

    public void setdImgUrl(String dImgUrl) {
        this.dImgUrl = dImgUrl;
    }

    public String getdHumidity() {
        return dHumidity;
    }

    public void setdHumidity(String dHumidity) {
        this.dHumidity = dHumidity;
    }

    public String getdPressure() {
        return dPressure;
    }

    public void setdPressure(String dPressure) {
        this.dPressure = dPressure;
    }

    public String getdClouds() {
        return dClouds;
    }

    public void setdClouds(String dClouds) {
        this.dClouds = dClouds;
    }

    public String getdWindSpeed() {
        return dWindSpeed;
    }

    public void setdWindSpeed(String dWindSpeed) {
        this.dWindSpeed = dWindSpeed;
    }

    public String getdWindType() {
        return dWindType;
    }

    public void setdWindType(String dWindType) {
        this.dWindType = dWindType;
    }

    public String getdWindDirection() {
        return dWindDirection;
    }

    public void setdWindDirection(String dWindDirection) {
        this.dWindDirection = dWindDirection;
    }
}
