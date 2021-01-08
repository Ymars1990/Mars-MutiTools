package com.mars.framework_base.base_java;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;

import com.mars.framework_base.R;
import com.mars.framework_base.databinding.ActivityBaseBinding;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_comutils_java.annotation.LoadStatus;

public abstract class BaseActivity<DB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements View.OnClickListener {
    //字体大小是否跟随系统
    protected boolean resIsFollowSystem = false;
    protected String TAG = BaseActivity.class.getSimpleName();

    protected DB mDataBinding;
    protected VM mViewModel;

    private ActivityBaseBinding mActivityBaseBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        LogUtils.logI(TAG, "生命周期", "onCreate");
        mActivityBaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        mDataBinding = DataBindingUtil.inflate(getLayoutInflater(), setLayout(),
                mActivityBaseBinding.flContentContainer, true);

        mDataBinding.setLifecycleOwner(this);
        initData();
        initViewModel();
        bindViewModel();

        initLoadState();


        // ViewModel订阅生命周期事件
        if (mViewModel != null) {
            getLifecycle().addObserver(mViewModel);
        }
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
        LogUtils.logI(TAG, "生命周期", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.logI(TAG, "生命周期", "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.logI(TAG, "生命周期", "onDestroy");
    }

    private void initLoadState() {
        if (mViewModel != null) {
            mViewModel.loadState.observe(this, new Observer<LoadStatus>() {
                @Override
                public void onChanged(LoadStatus loadState) {

                }
            });
        }
    }

    /**
     * 初始化ViewModel
     */
    protected abstract void initViewModel();

    /**
     * 绑定ViewModel
     */
    protected abstract void bindViewModel();

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

}
