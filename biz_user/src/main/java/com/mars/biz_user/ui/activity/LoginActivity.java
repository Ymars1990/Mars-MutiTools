package com.mars.biz_user.ui.activity;

import android.view.View;

import androidx.lifecycle.ViewModelProvider;

import com.mars.biz_user.R;
import com.mars.biz_user.databinding.ActivityLoginBinding;
import com.mars.biz_user.viewmodel.LoginViewModel;
import com.mars.framework_base.base_java.BaseActivity;
import com.mars.framework_comutils_java.ToastManger;
import com.mars.framework_comutils_java.annotation.LoadStatus;


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
        if (v.getId() == R.id.login) {
            mViewModel.login(mDataBinding.username.getText().toString(), mDataBinding.password.getText().toString());
        }
    }

    @Override
    protected void switchLoadView(LoadStatus loadStatus) {
        if (loadStatus == LoadStatus.Type.LOAD_SUCCESS) {
            ToastManger.showToast(this, "登陆成功");
        }
    }
}