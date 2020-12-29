package com.mars.framework_base.base_java;

import android.view.View;

/**
 * Rv点击事件回调接口
 *
 * @author Mars
 */
public interface BaseRvItemOnClicker<T> {
    void onRvItemClick(View v, T itemData, int pos);
}
