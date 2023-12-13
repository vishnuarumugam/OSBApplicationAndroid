package com.example.osbapplication.base;

import android.content.SharedPreferences;


public class SharedPrefRepo {
    private SharedPreferences mAppSharedpref;
    private SharedPreferences.Editor mAppSharedprefEditor;
    private static SharedPrefRepo sharePrefRepo;


    private final String EMAIL_ID=Constants.EMAIL;

    SharedPrefRepo() {
        mAppSharedpref = OSBApplication.getApplicationInstance().getSharedPreferences(Constants.APP_SHARED_DATA, 0);
        mAppSharedprefEditor = mAppSharedpref.edit();
    }

    public void clearSharePref(){
        mAppSharedprefEditor.clear();
        mAppSharedprefEditor.commit();
        mAppSharedprefEditor.apply();
    }

    public static SharedPrefRepo getInstance() {
        if (sharePrefRepo == null) {
            return sharePrefRepo = new SharedPrefRepo();
        } else {
            return sharePrefRepo;
        }
    }

    public void setFloatVale(String key,float value){
        mAppSharedprefEditor.putFloat(key,value);
        mAppSharedprefEditor.apply();
        mAppSharedprefEditor.commit();
    }
    public float getFloatVale(String key){
        return mAppSharedpref.getFloat(key,0.0f);
    }

    public void putString(String key, String value) {
        mAppSharedprefEditor.putString(key, value);
        mAppSharedprefEditor.apply();
    }

    public String getString(String key) {
        return mAppSharedpref.getString(key, null);
    }

    public void putInt(String key, int value) {
        mAppSharedprefEditor.putInt(key, value);
        mAppSharedprefEditor.apply();
        mAppSharedprefEditor.commit();
    }

    public int getInt(String key) {
        return mAppSharedpref.getInt(key, 0);
    }

    public void putBoolean(String key, boolean value) {
        mAppSharedprefEditor.putBoolean(key, value);
        mAppSharedprefEditor.apply();
        mAppSharedprefEditor.commit();
    }

    public void setEmailId(String email){
        mAppSharedprefEditor.putString(EMAIL_ID,email);
        mAppSharedprefEditor.apply();
    }

    public String getEmailId(){
        return mAppSharedpref.getString(EMAIL_ID,"");
    }

    public boolean getBoolean(String key) {
        return mAppSharedpref.getBoolean(key, false);
    }
}
