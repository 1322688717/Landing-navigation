package com.example.try_68;

import android.app.Application;

import com.example.try_68.utils.T;

public class ResApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        T.init(this);
    }
}
