package com.ujia.utils;

import android.content.SharedPreferences;
import android.support.v4.widget.NestedScrollView;

public class Preferences {
    private static Preferences preferences = new Preferences();
    private static SharedPreferences sp;

    public synchronized static Preferences getPreferences() {
        if (sp == null) {
            throw new NullPointerException("sp is null");
        }
        return preferences;
    }

    public static void initSharePreference(SharedPreferences p) {
        Preferences.sp = p;
    }

    private Preferences() {

    }


    public void putBoolean(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public void putFloat(String key, float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public void putInt(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public void putLong(String key, long value) {
        sp.edit().putLong(key, value).apply();
    }

    public void putString(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public float getFloat(String key) {
        return sp.getFloat(key, 0);
    }

    public float getFloat(String key, float defValue) {
        return sp.getFloat(key, defValue);
    }

    public int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public long getLong(String key) {
        return sp.getLong(key, 0);
    }

    public long getLong(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public String getString(String key) {
        return sp.getString(key, "");
    }

    public String getString(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public void removeValue(String key) {
        sp.edit().remove(key).apply();
    }
}
