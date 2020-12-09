package com.mars.mars_mutitools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.mars.framework_comutils.DeviceInforUtils;
import com.mars.framework_comutils.LogUtils;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.logI(TAG, "onCreate");
        LogUtils.logI(TAG, String.format("设备产商:%s", DeviceInforUtils.getDeviceBrand()));
        LogUtils.logI(TAG, String.format("设备系统语言:%s", DeviceInforUtils.getSystemLanguage()));
        LogUtils.logI(TAG, String.format("设备型号:%s", DeviceInforUtils.getSystemModel()));
        LogUtils.logI(TAG, String.format("设备系统版本:%s", DeviceInforUtils.getSystemVersion()));
        LogUtils.logI(TAG, String.format("设备序列号:%s", DeviceInforUtils.getSerialNumber()));
        LogUtils.logI(TAG, String.format("设备androidID:%s", DeviceInforUtils.getAndroidId(this)));
        LogUtils.logI(TAG, String.format("设备UUID:%s", DeviceInforUtils.getUuid(this)));
        LogUtils.logI(TAG, String.format("设备制造商:%s", DeviceInforUtils.getManufacturer()));
        LogUtils.logI(TAG, String.format("设备主板名:%s", DeviceInforUtils.getDeviceBoand()));
        LogUtils.logI(TAG, String.format("设备名:%s", DeviceInforUtils.getDeviceName()));
        LogUtils.logI(TAG, String.format("设备语言列表:%s", DeviceInforUtils.getSystemLanguageList()));
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            LogUtils.logI(TAG, String.format("设备IMEI:%s", DeviceInforUtils.getIMEI(this)));
        }
    }
}