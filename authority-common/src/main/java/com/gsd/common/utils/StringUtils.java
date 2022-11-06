package com.gsd.common.utils;

public class StringUtils {
    private static String NULLSTR = "";

    public static boolean isNull(Object object) {
        return object == null;
    }
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
    public static boolean isEmpty(String str) {
        return isNull(str) || NULLSTR.equals(str.trim());
    }
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
