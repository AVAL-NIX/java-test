package com.zx.framework.util;

/**
 * @author zhengxin
 * @date 2021/3/15
 */
public final class ServletUtils {

    /**
     * 把字符串的首字母小写
     *
     * @param name
     * @return
     */
    public static String toLowerFirstWord(String name) {
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }

}
