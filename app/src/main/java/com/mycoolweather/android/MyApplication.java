package com.mycoolweather.android;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

public class MyApplication extends Application {
   private  static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        LitePal.initialize(this);
    }

    public static Context getmContext() {
        return mContext;
    }
}
