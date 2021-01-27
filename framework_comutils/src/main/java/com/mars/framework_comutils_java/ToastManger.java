package com.mars.framework_comutils_java;

import android.content.Context;
import android.view.Gravity;
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
                toast = Toast.makeText(mCtx, msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
            }
            toast.show();
        }
    }

    public static void showToast(Context mCtx, String msg, int duration) {
        if (StringUtils.isNotNullString(msg) && mCtx != null) {
            if (toast == null) {
                toast = Toast.makeText(mCtx, msg, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(duration);
            }
            toast.show();
        }
    }
}


