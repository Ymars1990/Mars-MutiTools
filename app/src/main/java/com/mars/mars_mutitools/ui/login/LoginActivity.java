package com.mars.mars_mutitools.ui.login;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.mars.framework_base.base_java.BaseActivity;
import com.mars.framework_comutils_java.annotation.LoadStatus;
import com.mars.mars_mutitools.R;
import com.mars.mars_mutitools.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {


    @Override
    protected void initViewModel() {
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    protected void bindViewModel() {
        mDataBinding.setViewModel(mViewModel);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                mViewModel.login(mDataBinding.password.getText().toString(), mDataBinding.username.getText().toString());
                break;
        }
    }
}