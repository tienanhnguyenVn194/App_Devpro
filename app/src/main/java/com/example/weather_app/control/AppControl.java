package com.example.weather_app.control;

import android.app.Application;

import com.google.gson.Gson;

public class AppControl extends Application {
    private static AppControl mSelf;
    private Gson mGSon;

    public static AppControl self(){
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
        mGSon = new Gson();
    }

    public Gson getGSon(){
        return mGSon;
    }
}
