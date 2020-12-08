package com.mars.mars_mutitools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mars.framework_comutils.LogUtils;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.logI(TAG,"onCreate");
    }
}