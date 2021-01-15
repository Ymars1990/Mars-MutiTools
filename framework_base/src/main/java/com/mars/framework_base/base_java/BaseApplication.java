package com.mars.framework_base.base_java;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

public abstract class BaseApplication extends MultiDexApplication {
    private volatile static BaseApplication singleton = null;
    private static Context context;
    public static Context getContext() {
        return context;
    }
    public static BaseApplication getSingleton() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }
}
