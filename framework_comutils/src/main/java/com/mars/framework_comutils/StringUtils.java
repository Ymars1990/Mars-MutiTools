package com.mars.framework_comutils;

public class StringUtils {
    //对象转String
    public static String objs2tring(Object object) {
        if (object != null) {
            return String.format("%s", object);
        } else {
            return String.format("%s");
        }
    }

    //判断String对象是否为null
    public static boolean isStringNull(String obj) {
        return obj != null;
    }

    //判断String对象是否为空字符串（含全空格）
    public static boolean isNullString(String obj) {
        return obj != null && "".equals(obj.replaceAll(" ", ""));
    }
}
