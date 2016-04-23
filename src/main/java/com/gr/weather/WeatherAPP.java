package com.gr.weather;

import android.app.Application;

import org.xutils.x;

/**
 * Created by GR on 2016/4/19.
 */
public class WeatherAPP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
