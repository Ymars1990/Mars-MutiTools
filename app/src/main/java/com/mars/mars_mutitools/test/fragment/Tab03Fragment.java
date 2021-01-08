package com.mars.mars_mutitools.test.fragment;

import android.view.View;
import android.widget.TextView;

import com.mars.framework_base.base_java.BaseFragment;
import com.mars.mars_mutitools.R;

public class Tab03Fragment extends BaseFragment {

    private TextView tv;

    @Override
    protected void initView() {
        tv = fvbi(R.id.tv);

        tv.setText(TAG);
    }


    @Override
    protected int setLayout() {
        return R.layout.fragment_tab01;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}