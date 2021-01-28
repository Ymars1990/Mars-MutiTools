package com.mars.mars_mutitools.test.viewmodel;

import com.mars.framework_base.base_java.BaseViewModel;
import com.mars.framework_comutils_java.LogUtils;
import com.mars.framework_net.HttpDisposable;
import com.mars.framework_net.HttpManager;
import com.mars.mars_mutitools.test.ApiInterface;
import com.mars.mars_mutitools.test.bean.WeChatBean;

import java.util.ArrayList;


public class MainViewModel extends BaseViewModel {

    public MainViewModel() {
        TAG = this.getClass().getSimpleName();
    }


    public void getWxarticle() {
        HttpManager.get().getRetrofit().create(ApiInterface.class).getWxarticle()
                .compose(HttpManager.schedulers())
                .subscribe(new HttpDisposable<ArrayList<WeChatBean>>() {

                    @Override
                    public void onSuccess(ArrayList<WeChatBean> o) {
                        LogUtils.logI(TAG, o.toString());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        LogUtils.logI(TAG, String.format("code[%s],Msg[%s],Erro[%s]", code, msg));
                    }
                });
    }
}
