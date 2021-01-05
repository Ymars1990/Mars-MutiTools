package com.mars.framework_base.base_java;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mars.framework_comutils_java.LogUtils;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    //字体大小是否跟随系统
    protected boolean resIsFollowSystem = false;
    protected String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        LogUtils.logI(TAG, "生命周期","onCreate");
        setContentView(setLayout());
        initData();
        initView();
    }


    @Override
    public Resources getResources() {
        if (resIsFollowSystem) {
            return super.getResources();
        } else {
            Resources resources = super.getResources();
            Configuration newConfig = resources.getConfiguration();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();

            if (newConfig.fontScale != 1) {
                newConfig.fontScale = 1;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Context configurationContext = createConfigurationContext(newConfig);
                    resources = configurationContext.getResources();
                    displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale;
                } else {
                    resources.updateConfiguration(newConfig, displayMetrics);
                }
            }
            return resources;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.logI(TAG, "生命周期","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.logI(TAG, "生命周期","onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.logI(TAG, "生命周期","onDestroy");
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract int setLayout();

    /**
     * 初始化参数
     *
     * @return
     */
    protected abstract void initData();

    /**
     * 初始化布局
     *
     * @return
     */
    protected abstract void initView();

    /**
     * 简化findViewById()
     *
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T fvbi(int resId) {
        return (T) findViewById(resId);
    }
}
