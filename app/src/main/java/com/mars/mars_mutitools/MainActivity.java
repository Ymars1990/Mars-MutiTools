package com.mars.mars_mutitools;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mars.framework_comutils_java.DeviceInforUtils;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_comutils_java.StringUtils;
import com.mars.framework_comutils_kotlin.KtStringUtils;
import com.tencent.mmkv.MMKV;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private TextView showTv;
    int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTv = findViewById(R.id.showTv);

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
        LogUtils.logI(TAG, String.format("设备宽度（px）:%s", DeviceInforUtils.getDevWidth(this)));
        LogUtils.logI(TAG, String.format("设备高度（px）:%s", DeviceInforUtils.getDevHeight(this)));
        LogUtils.logI(TAG, String.format("设备真实宽度（px）:%s", DeviceInforUtils.getDevRealWidth(this)));
        LogUtils.logI(TAG, String.format("设备真实高度（px）:%s", DeviceInforUtils.getDevRealHeight(this)));
        LogUtils.logI(TAG, String.format("设备屏幕密度（px）:%s", DeviceInforUtils.getDevDensity(this)));
        LogUtils.logI(TAG, String.format("设备屏幕密度DPI（px）:%s", DeviceInforUtils.getDevDensityDpi(this)));


        MMKV kv = MMKV.defaultMMKV();
        n = kv.decodeInt("test");
        LogUtils.logI(TAG, n);
        showTv.setText(String.format("Hello:%s", kv.decodeInt("test")));
        showTv.setOnClickListener(v -> {
            n++;
            kv.encode("test", n);
            showTv.setText(String.format("Hello:%s", kv.decodeInt("test")));
        });

        LogUtils.logI(TAG,"开始时间："+System.currentTimeMillis());
        LogUtils.logI(TAG, KtStringUtils.Companion.objs2String(null));
        LogUtils.logI(TAG, KtStringUtils.Companion.objs2String("ss"));
        LogUtils.logI(TAG, KtStringUtils.Companion.objs2String(1));
        LogUtils.logI(TAG, KtStringUtils.Companion.objs2String(3.11f));
        LogUtils.logI(TAG, KtStringUtils.Companion.objs2String(0x02));
        LogUtils.logI(TAG, KtStringUtils.Companion.isNullString(" "));
        LogUtils.logI(TAG, KtStringUtils.Companion.isNullString(""));
        LogUtils.logI(TAG, KtStringUtils.Companion.isNullString(null));
        LogUtils.logI(TAG, KtStringUtils.Companion.isNotNullString(null));
        LogUtils.logI(TAG, KtStringUtils.Companion.isNullString("111"));
        LogUtils.logI(TAG,"结束时间："+System.currentTimeMillis());

        LogUtils.logI(TAG,"开始时间："+System.currentTimeMillis());
        LogUtils.logI(TAG, StringUtils.objs2String(null));
        LogUtils.logI(TAG, StringUtils.objs2String("ss"));
        LogUtils.logI(TAG, StringUtils.objs2String(1));
        LogUtils.logI(TAG, StringUtils.objs2String(3.11f));
        LogUtils.logI(TAG, StringUtils.objs2String(0x02));
        LogUtils.logI(TAG, StringUtils.isNullString(" "));
        LogUtils.logI(TAG, StringUtils.isNullString(""));
        LogUtils.logI(TAG, StringUtils.isNullString(null));
        LogUtils.logI(TAG, StringUtils.isNotNullString(null));
        LogUtils.logI(TAG, StringUtils.isNullString("111"));
        LogUtils.logI(TAG,"结束时间："+System.currentTimeMillis());
    }


}