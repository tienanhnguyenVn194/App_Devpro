package com.example.weather_app.control;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    private static final String PREFS_NAME = "shared_prefs";
    private static SharedPrefs mInstance;
    private SharedPreferences mSharedPreferences;

    private SharedPrefs(){
        mSharedPreferences = AppControl.self().getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
    }

    public static SharedPrefs getmInstance(){
        if (mInstance == null)
            mInstance = new SharedPrefs();
        return mInstance;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass){
        if (anonymousClass == String.class)
            return (T) mSharedPreferences.getString(key, "");
        else if (anonymousClass == Boolean.class)
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, false));
        else if (anonymousClass == Float.class)
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, 0));
        else if (anonymousClass == Integer.class)
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, 0));
        else if (anonymousClass == Long.class)
            return (T) Long.valueOf(mSharedPreferences.getLong(key, 0));
        else
            return (T) AppControl.self().getGSon().fromJson(mSharedPreferences.getString(key, ""), anonymousClass);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> anonymousClass, T defaultValue){
        if (anonymousClass == String.class)
            return (T) mSharedPreferences.getString(key, (String) defaultValue);
        else if (anonymousClass == Boolean.class)
            return (T) Boolean.valueOf(mSharedPreferences.getBoolean(key, (Boolean) defaultValue));
        else if (anonymousClass == Float.class)
            return (T) Float.valueOf(mSharedPreferences.getFloat(key, (Float) defaultValue));
        else if (anonymousClass == Integer.class)
            return (T) Integer.valueOf(mSharedPreferences.getInt(key, (Integer) defaultValue));
        else if (anonymousClass == Long.class)
            return (T) Long.valueOf(mSharedPreferences.getLong(key, (Long) defaultValue));
        else
            return (T) AppControl.self().getGSon().fromJson(mSharedPreferences.getString(key, ""), anonymousClass);
    }

    public <T> void put(String key, T data){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (data instanceof String)
            editor.putString(key, (String) data);
        else if (data instanceof Boolean)
            editor.putBoolean(key, (Boolean) data);
        else if (data instanceof Float)
            editor.putFloat(key, (Float) data);
        else if (data instanceof Integer)
            editor.putInt(key, (Integer) data);
        else if (data instanceof Long)
            editor.putLong(key, (Long) data);
        else
            editor.putString(key, AppControl.self().getGSon().toJson(data));
        editor.apply();
    }

    public void clear(){
        mSharedPreferences.edit().clear().apply();
    }
}
