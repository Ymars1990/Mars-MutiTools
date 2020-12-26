package com.mars.mars_mutitools;

import android.content.res.Configuration;
import android.content.res.Resources;

import androidx.multidex.MultiDexApplication;

import com.mars.framework_comutils_java.LogUtils;
import com.tencent.mmkv.MMKV;

public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logI("BaseApplication", "onCreate ");
        String rootDir = MMKV.initialize(this);
        LogUtils.logI("BaseApplication", "mmkv root: " + rootDir);
        useDefaultResConfig();
    }

    private void useDefaultResConfig() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}
