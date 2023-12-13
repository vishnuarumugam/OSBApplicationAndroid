package com.example.osbapplication.base;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.osbapplication.firebase.MyFirebaseInstanceIDService;

public class OSBApplication extends Application{

    private static Application application;
    public static Context mContext;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = this;

        ComponentName componentName = new ComponentName(
                mContext,
                MyFirebaseInstanceIDService.class);

        mContext.getPackageManager().setComponentEnabledSetting(
                componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    public static Application getApplicationInstance() {
        return application;
    }
}
