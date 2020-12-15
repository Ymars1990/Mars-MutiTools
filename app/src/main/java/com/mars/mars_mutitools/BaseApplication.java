package com.mars.mars_mutitools;

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
    }
}
