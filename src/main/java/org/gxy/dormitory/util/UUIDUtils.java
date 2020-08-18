package org.gxy.dormitory.util;

import java.util.UUID;

/**
 * UUID生成工具
 *
 * @auther 孙鹏轩
 * @date 2020-03-30
 */
public class UUIDUtils {
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        uuid = "402881e" + uuid.substring(0, 25);
        return uuid;
    }
}
