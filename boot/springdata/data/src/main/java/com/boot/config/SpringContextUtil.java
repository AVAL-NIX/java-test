package com.boot.config;

import org.springframework.context.ApplicationContext;

/**
 * Spring 上下文工具类
 *
 * @author lizhi_zheng
 */
public class SpringContextUtil {

    private static ApplicationContext appContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        appContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return appContext;
    }

    public static <T> T getBean(Class<T> clazz) {

        return appContext.getBean(clazz);
    }

}
