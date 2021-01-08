package com.mars.framework_base.base_java;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.mars.framework_comutils_java.LogUtils;

public interface BaseLifeCycleObsever extends DefaultLifecycleObserver {
    String TAG = BaseLifeCycleObsever.class.getSimpleName();

    @Override
    default void onCreate(@NonNull LifecycleOwner owner) {
        LogUtils.logI(TAG, "onCreate");
    }

    @Override
    default void onDestroy(@NonNull LifecycleOwner owner) {
        LogUtils.logI(TAG, "onDestroy");

    }

    @Override
    default void onPause(@NonNull LifecycleOwner owner) {
        LogUtils.logI(TAG, "onPause");

    }

    @Override
    default void onResume(@NonNull LifecycleOwner owner) {
        LogUtils.logI(TAG, "onResume");

    }

    @Override
    default void onStart(@NonNull LifecycleOwner owner) {
        LogUtils.logI(TAG, "onStart");

    }

    @Override
    default void onStop(@NonNull LifecycleOwner owner) {
        LogUtils.logI(TAG, "onStop");

    }
}
