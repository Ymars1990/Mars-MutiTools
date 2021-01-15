package com.mars.mars_mutitools.ui.login;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.mars.framework_base.base_java.BaseViewModel;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_comutils_java.ToastManger;
import com.mars.framework_comutils_java.annotation.LoadStatus;
import com.mars.framework_net.HttpDisposable;
import com.mars.framework_net.HttpManager;
import com.mars.mars_mutitools.test.ApiInterface;
import com.mars.mars_mutitools.test.bean.LoginBean;

public class LoginViewModel extends BaseViewModel {

    /**
     * 登陆用户信息
     */
    private MutableLiveData<LoginBean> userBean = new MutableLiveData<>();

    public void login(String password, String username) {
        HttpManager.get().getRetrofit().create(ApiInterface.class).login(password, username)
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
}
