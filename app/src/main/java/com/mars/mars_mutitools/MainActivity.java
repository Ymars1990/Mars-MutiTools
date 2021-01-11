package com.mars.mars_mutitools;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.mars.framework_base.base_java.BaseActivity;
import com.mars.mars_mutitools.databinding.ActivityMainBinding;
import com.mars.mars_mutitools.test.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {


    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Override
    protected void bindViewModel() {
        mDataBinding.setViewModel(mViewModel);
        mViewModel.getWxarticle();
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {

    }
}