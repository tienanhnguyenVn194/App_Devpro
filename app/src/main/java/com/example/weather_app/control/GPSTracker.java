package com.example.weather_app.control;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;

import androidx.core.content.ContextCompat;

public class GPSTracker implements LocationListener {
    private Context context;

    public GPSTracker(Context context) {
        this.context = context;
    }

    public Location getLocation(){
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            //Khong cap quyen truy cap vi tri cho ung dung
            return null;
        }
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean enableGPS = false;
        if (manager != null)
            enableGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (enableGPS){
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
            return manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } else {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
