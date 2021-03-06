package com.mars.framework_comutils_java;


import android.util.Log;

public class LogUtils {
    private static boolean isOutPutLog = BuildConfig.DEBUG;

    public static void logI(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.i(tag, StringUtils.objs2String(value));
            } else {
                Log.i("LogUtils", StringUtils.objs2String(value));
            }
        }
    }

    public static void logI(String tag, String key, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.i(tag, String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            } else {
                Log.i("LogUtils", String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            }
        }
    }

    public static void logV(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.v(tag, StringUtils.objs2String(value));
            } else {
                Log.v("LogUtils", StringUtils.objs2String(value));
            }
        }
    }

    public static void logV(String tag, String key, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.v(tag, String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            } else {
                Log.v("LogUtils", String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            }
        }
    }

    public static void logD(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.d(tag, StringUtils.objs2String(value));
            } else {
                Log.d("LogUtils", StringUtils.objs2String(value));
            }
        }
    }

    public static void logD(String tag, String key, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.d(tag, String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            } else {
                Log.d("LogUtils", String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            }
        }
    }

    public static void logE(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.e(tag, StringUtils.objs2String(value));
            } else {
                Log.e("LogUtils", StringUtils.objs2String(value));
            }
        }
    }

    public static void logE(String tag, String key, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.e(tag, String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            } else {
                Log.e("LogUtils", String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            }
        }
    }

    public static void logW(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.w(tag, StringUtils.objs2String(value));
            } else {
                Log.w("LogUtils", StringUtils.objs2String(value));
            }
        }
    }

    public static void logW(String tag, String key, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.w(tag, String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            } else {
                Log.w("LogUtils", String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            }
        }
    }

    public static void logWtf(String tag, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.wtf(tag, StringUtils.objs2String(value));
            } else {
                Log.wtf("LogUtils", StringUtils.objs2String(value));
            }
        }
    }

    public static void logWtf(String tag, String key, Object value) {
        if (isOutPutLog) {
            if (StringUtils.isStringNull(tag)) {
                Log.wtf(tag, String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            } else {
                Log.wtf("LogUtils", String.format("%s-->%s", StringUtils.objs2String(key), StringUtils.objs2String(value)));
            }
        }
    }
}
