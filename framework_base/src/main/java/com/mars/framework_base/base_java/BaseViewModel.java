package com.mars.framework_base.base_java;

import android.content.res.Resources;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mars.framework_comutils_java.annotation.LoadStatus;

public abstract class BaseViewModel extends ViewModel implements BaseLifeCycleObsever {
    public Resources resources;
    protected String TAG = BaseViewModel.class.getSimpleName();
    protected MutableLiveData<LoadStatus> loadStatus = new MutableLiveData<>();
    public MutableLiveData<String> tipMsg = new MutableLiveData<>();


    public Resources getResources() {
        if (resources == null) {
            resources = BaseApplication.getSingleton().getResources();
        }
        return resources;
    }

    public void reloadData() {
    }
}
