package com.tomcat.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengxin
 * @date 2021/5/2
 */
@Configuration
@ComponentScan(basePackages = "com.rpc")
public class SpringConfig {

    @Bean(name="gpRpcServer")
    public GpRpcServer gpRpcServer(){
        return new GpRpcServer(8080);
    }

}
