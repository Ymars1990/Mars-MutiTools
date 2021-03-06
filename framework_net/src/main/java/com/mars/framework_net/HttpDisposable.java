package com.mars.framework_net;

import io.reactivex.observers.DisposableObserver;

public abstract class HttpDisposable<T> extends DisposableObserver<T> {

    public HttpDisposable() {
    }

    @Override
    protected void onStart() {
    }

    @Override
    public void onNext(T value) {
        onSuccess(value);

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException) {
            onError(((HttpException) e).getCode(), e.getMessage());
        } else {
            onError(0xEE, String.format("异常[%s]", e.getMessage()));
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T o);

    public abstract void onError(int code, String msg);
}