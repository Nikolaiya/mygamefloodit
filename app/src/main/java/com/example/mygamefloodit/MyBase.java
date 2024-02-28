package com.example.mygamefloodit;

import android.content.Context;
import android.content.SharedPreferences;

public class MyBase {
    public static final String SHARED_PREF = "sharedPref";
    public static final String IS_NIGHT_MODE = "isNightMode";
    public static final String IS_MUSIC_ENABLED = "isMusicEnabled";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public MyBase(Context context){
        preferences = context.getSharedPreferences(SHARED_PREF,Context.MODE_PRIVATE);
        editor = preferences.edit();
    }
    public void saveMode(boolean mode) {
        editor.putBoolean(IS_NIGHT_MODE, mode).commit();
    }
    public boolean getMode(){
        return preferences.getBoolean(IS_NIGHT_MODE, false);
    }
    public void saveMusicEnabled(boolean isEnabled) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("music_enabled", isEnabled);
        editor.apply();
    }

    public boolean getMusicEnabled() {
        return preferences.getBoolean("music_enabled", false);
    }
}
