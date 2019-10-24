package com.example.weather_app.control;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkTracker {
    private Context context;

    public NetworkTracker(Context context) {
        this.context = context;
    }

    public boolean enableNetwork(){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if (manager != null){
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null)
                return info.getState() == NetworkInfo.State.CONNECTED;
        }
        return false;
    }
}
