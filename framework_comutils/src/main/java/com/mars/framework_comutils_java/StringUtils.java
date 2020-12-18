package com.mars.framework_comutils_java;

public class StringUtils {
    //对象转String
    public static String objs2String(Object object) {
        if (object != null) {
            return String.format("%s", object);
        } else {
            return String.format("Obj is Null");
        }
    }

    //判断String对象是否为null
    public static boolean isStringNull(String obj) {
        return obj != null;
    }

    //判断String对象是否为空字符串（含全空格）
    public static boolean isNullString(String obj) {
        return obj == null || "".equals(obj.replaceAll(" ", ""));
    }

    //判断String对象是否为空字符串（含全空格）
    public static boolean isNotNullString(String obj) {
        return obj != null && !"".equals(obj.replaceAll(" ", ""));
    }
}
