package com.zx.framework;

import com.zx.framework.context.ZXApplicationContext;

/**
 * @author zhengxin
 * @date 2021/3/14
 */
public class Test {

    public static void main(String[] args) {
        ZXApplicationContext zxApplicationContext = new ZXApplicationContext("classpath:application.properties");
        System.out.println(zxApplicationContext);
    }
}
