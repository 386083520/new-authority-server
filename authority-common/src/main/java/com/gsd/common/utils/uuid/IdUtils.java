package com.gsd.common.utils.uuid;

import java.util.UUID;

public class IdUtils {
    public static String simpleUUID() {
        return UUID.randomUUID().toString();
    }
}
