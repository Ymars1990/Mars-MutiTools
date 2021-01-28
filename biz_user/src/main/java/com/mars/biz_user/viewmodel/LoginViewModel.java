package com.mars.biz_user.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.mars.biz_user.UserApiInterface;
import com.mars.biz_user.bean.LoginBean;
import com.mars.framework_base.base_java.BaseApplication;
import com.mars.framework_base.base_java.BaseViewModel;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_comutils_java.NetworkUtils;
import com.mars.framework_comutils_java.annotation.LoadStatus;
import com.mars.framework_net.HttpDisposable;
import com.mars.framework_net.HttpManager;


public class LoginViewModel extends BaseViewModel {

    /**
     * 登陆用户信息
     */
    private MutableLiveData<LoginBean> userBean = new MutableLiveData<>();

    public void login(String username, String password) {
        //判断网络
        if (!NetworkUtils.isConnected(BaseApplication.getSingleton())) {
            loadStatus.postValue(LoadStatus.Type.LOAD_NEWWORK_ERROR);
            return;
        }
        HttpManager.get().getRetrofit().create(UserApiInterface.class).login(username, password)
                .compose(HttpManager.schedulers())
                .subscribe(new HttpDisposable<LoginBean>() {

                    @Override
                    public void onSuccess(LoginBean o) {
                        userBean.postValue(o);
                        loadStatus.postValue(LoadStatus.Type.LOAD_SUCCESS);
                        LogUtils.logI(TAG, o.toString());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        loadStatus.postValue(LoadStatus.Type.LOAD_FAILED);
                        tipMsg.postValue(msg);
                        LogUtils.logI(TAG, String.format("code[%s],Msg[%s]", code, msg));
                    }
                });
    }

    @Override
    public void reloadData() {
        login("Mars1990", "12345678");
    }
}
