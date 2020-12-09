package com.mars.framework_comutils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.util.Locale;
import java.util.UUID;

/**
 * @author Mars
 * 获取设备信息工具类
 */
public class DeviceInforUtils {
    /**
     * 获取当前设备系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static String getSystemLanguageList() {
        return Locale.getAvailableLocales().toString();
    }

    /**
     * 获取当前设备系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }


    /**
     * 获取手机主板名
     *
     * @return  主板名
     */
    public static String getDeviceBoand() {
        return Build.BOARD;
    }
    /**
     * 获取设备型号
     *
     * @return 设备型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取设备厂商
     *
     * @return 设备厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取设备IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return 设备IMEI
     */
    public static String getIMEI(Context ctx) {
        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
        if (tm != null) {
            return tm.getImei();
        }
        return null;
    }

    /**
     * 获取设备序列号
     */
    public static String getSerialNumber() {
        return Build.SERIAL;
    }

    /**
     * 获取设备制造商
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取设备名
     */
    public static String getDeviceName() {
        return Build.DEVICE;
    }

    /**
     * 获取AndroidID
     * 在设备首次启动时，系统会随机生成一个64位的数字，并把这个数字以16进制字符串的形式保存下来，这个16进制的字符串就是ANDROID_ID，当设备被wipe后该值会被重置。
     * 1. 厂商定制系统的Bug：不同的设备可能会产生相同的ANDROID_ID：9774d56d682e549c。
     * 2. 厂商定制系统的Bug：有些设备返回的值为null。
     * 3. 设备差异：对于CDMA设备，ANDROID_ID和TelephonyManager.getDeviceId() 返回相同的值
     *
     * @return 设备IMEI
     */
    public static String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
    }

    /**
     * 获取 UUID
     * android 每次都不一样
     */
    public static String getUuid(Context context) {
        // UUID 键
        String key = "key_uuid";
        // 获取 SharedPreferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        // 获取 UUID
        String uuid = preferences.getString(key, "");
        // UUID 为空值
        if (StringUtils.isStringNull(uuid)) {
            // 创建新的 UUID
            uuid = UUID.randomUUID().toString();
            // 保存
            preferences.edit().putString(key, uuid).apply();
        }
        return uuid;
    }
}
