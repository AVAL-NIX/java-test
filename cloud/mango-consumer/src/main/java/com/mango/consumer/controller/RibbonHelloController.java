package com.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhengxin
 * @date 2020/11/16
 */
@RestController
public class RibbonHelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon/call")
    public String call(){
        //
        String forObject = restTemplate.getForObject("http://mango-producer/hello", String.class);
        return forObject;
    }
}
