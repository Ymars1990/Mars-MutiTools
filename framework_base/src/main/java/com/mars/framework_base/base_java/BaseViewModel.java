package com.mars.framework_base.base_java;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mars.framework_comutils_java.annotation.LoadStatus;

public abstract class BaseViewModel extends ViewModel implements BaseLifeCycleObsever {

    protected String TAG = BaseViewModel.class.getSimpleName();
    protected MutableLiveData<LoadStatus> loadStatus = new MutableLiveData<>();
    /**
     * 加载状态
     */
    protected MutableLiveData<LoadStatus> loadState = new MutableLiveData<>();

}
