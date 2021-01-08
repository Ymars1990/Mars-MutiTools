package com.mars.framework_net;

import android.widget.Toast;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseObserver<T> implements Observer<T> {

    private ObserverResponseListener listener;

    public BaseObserver(ObserverResponseListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T o) {
        BaseResponse resp = (BaseResponse) o;
        int code = resp.getErrorCode();
        if (code == NetConstant.REQUSET_SUCCESS_CODE) {
            listener.onSuccess(resp.getData(), resp.getErrorCode(), resp.getMsg());
        } else {
            listener.onFailed(resp.getData(), resp.getErrorCode(), resp.getMsg());
        }
    }

    @Override
    public void onError(Throwable e) {
        listener.onError(e, 0xEE, "异常");
    }

    @Override
    public void onComplete() {

    }
}