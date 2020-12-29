package com.mars.framework_comutils_java;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Mars
 * Toast 管理工具类
 */
public class ToastManger {
    private static Toast toast;

    public static void showToast(Context mCtx, String msg) {
        if (StringUtils.isNotNullString(msg) && mCtx != null) {
            if (toast == null) {
                toast = new Toast(mCtx);
            }
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        }
    }

    public static void showToast(Context mCtx, String msg, int duration) {
        if (StringUtils.isNotNullString(msg) && mCtx != null) {
            if (toast == null) {
                toast = new Toast(mCtx);
            }
            toast.setDuration(duration);
            toast.setText(msg);
            toast.show();
        }
    }
}


