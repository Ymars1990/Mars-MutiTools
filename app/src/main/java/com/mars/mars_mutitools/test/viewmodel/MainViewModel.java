package com.mars.mars_mutitools.test.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.mars.framework_base.base_java.BaseViewModel;
import com.mars.mars_mutitools.test.bean.LoginBean;


public class MainViewModel extends BaseViewModel {

    public MainViewModel() {
        TAG = this.getClass().getSimpleName();
        userBean = new MutableLiveData<>();
    }

    /**
     * 自动登陆
     *
     * @param name
     * @param pwd
     */
    /**
     * 登陆用户信息
     */
    private MutableLiveData<LoginBean> userBean;

}
