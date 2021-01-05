package com.mars.framework_base.base_java;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mars.framework_comutils_java.LogUtils;

/**
 * 基类Fragment
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected Context mContext;

    protected String TAG = BaseFragment.class.getSimpleName();

    /**
     * 当fragment与activity发生关联时调用
     *
     * @param context 与之相关联的activity
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        TAG = this.getClass().getSimpleName();
        LogUtils.logI(TAG, "生命周期", "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), null);
        LogUtils.logI(TAG, "生命周期", "onCreateView");
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtils.logI(TAG, "生命周期", "onViewCreated");
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LogUtils.logI(TAG, "生命周期", "onActivityCreated");
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.logI(TAG, "生命周期", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.logI(TAG, "生命周期", "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.logI(TAG, "生命周期", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.logI(TAG, "生命周期", "onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        LogUtils.logI(TAG, "生命周期", "onDetach");
    }

    /**
     * 初始化组件
     */
    protected abstract void initView();

    /**
     * 绑定布局
     *
     * @return
     */
    protected abstract int setLayout();

    /**
     * 设置数据等逻辑代码
     */
    protected abstract void initData();

    /**
     * 简化findViewById
     *
     * @param resId
     * @param <T>
     * @return
     */
    protected <T extends View> T fvbi(int resId) {
        return (T) getView().findViewById(resId);

    }

}
