package com.example.weather_app.control;

import com.example.weather_app.R;

public class Common {
    public static int windType(double wind_speed){
        int idType;
        if (wind_speed < 0.3)
            idType = R.string.calm;
        else if (wind_speed < 1.5)
            idType = R.string.light_air;
        else if (wind_speed < 3.3)
            idType = R.string.light_breeze;
        else if (wind_speed < 5.5)
            idType = R.string.gentle_breeze;
        else if (wind_speed < 7.9)
            idType = R.string.moderate_breeze;
        else if (wind_speed < 10.7)
            idType = R.string.fresh_breeze;
        else if (wind_speed < 13.8)
            idType = R.string.strong_breeze;
        else if (wind_speed < 17.1)
            idType = R.string.high_wind;
        else if (wind_speed < 20.7)
            idType = R.string.gale;
        else if (wind_speed < 24.4)
            idType = R.string.strong_gale;
        else if (wind_speed < 28.4)
            idType = R.string.storm;
        else if (wind_speed < 32.6)
            idType = R.string.violent_storm;
        else
            idType = R.string.hurricane;
        return idType;
    }

    public static int windDirection (double deg){
        int direction[] = {
                R.string.N, R.string.NNE, R.string.NE,
                R.string.ENE, R.string.E, R.string.ESE,
                R.string.SE, R.string.SSE, R.string.S,
                R.string.SSW, R.string.SW, R.string.WSW,
                R.string.W, R.string.WNW, R.string.NW,
                R.string.NNW, R.string.N
        };
        return direction[(int) Math.round(deg%360/22.5)];
    }
}
