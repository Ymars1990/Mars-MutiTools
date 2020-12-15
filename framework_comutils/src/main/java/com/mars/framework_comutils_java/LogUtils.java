package com.mars.framework_comutils_java;


import android.util.Log;

public class LogUtils {
    private static boolean isOutPutLog = BuildConfig.DEBUG;

    public static void logI(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.i(tag, StringUtils.objs2tring(value));
            } else {
                Log.i("LogUtils", StringUtils.objs2tring(value));
            }
        }
    }


    public static void logV(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.v(tag, StringUtils.objs2tring(value));
            } else {
                Log.v("LogUtils", StringUtils.objs2tring(value));
            }
        }
    }

    public static void logD(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.d(tag, StringUtils.objs2tring(value));
            } else {
                Log.d("LogUtils", StringUtils.objs2tring(value));
            }
        }
    }

    public static void logE(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.e(tag, StringUtils.objs2tring(value));
            } else {
                Log.e("LogUtils", StringUtils.objs2tring(value));
            }
        }
    }


    public static void logW(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.w(tag, StringUtils.objs2tring(value));
            } else {
                Log.w("LogUtils", StringUtils.objs2tring(value));
            }
        }
    }


    public static void logWtf(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.wtf(tag, StringUtils.objs2tring(value));
            } else {
                Log.wtf("LogUtils", StringUtils.objs2tring(value));
            }
        }
    }
}
