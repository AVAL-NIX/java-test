package com.rpc.controller;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhengxin
 * @date 2021/5/2
 */
@Target(ElementType.TYPE) //类或者接口
@Retention(RetentionPolicy.RUNTIME)
@Component // 被spring进行扫描
public @interface RpcService {

    Class<?> value(); // 拿到服务名的接口
     String version() default "1"; // 拿到服务名的版本
}
