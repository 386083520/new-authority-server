package com.gsd.common.utils;

public class StringUtils {
    public static boolean isNull(Object object) {
        return object == null;
    }
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}
