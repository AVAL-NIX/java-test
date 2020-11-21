package com.mango.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * WEB 配置， 跨域配置
 *
 * @author zhengxin
 * @date 2020/11/12
 */
@Configuration
public class WebMvcMyConfigurer implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}