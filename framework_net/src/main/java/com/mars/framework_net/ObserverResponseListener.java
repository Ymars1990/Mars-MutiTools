package com.mars.framework_net;

public interface ObserverResponseListener<T> {

    void onSuccess(T o, int code, String msg);

    void onFailed(T o, int code, String msg);

    void onError(Throwable e, int code, String msg);
}