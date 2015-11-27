package com.joker.mydemo.base;

import android.app.Application;

import com.joker.mydemo.utils.VolleyHelper;

/**
 * Created by Joker on 2015/11/27.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyHelper.getInstance().init(getApplicationContext());
    }


}
