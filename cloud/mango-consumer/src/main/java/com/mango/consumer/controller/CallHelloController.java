package com.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhengxin
 * @date 2020/11/16
 */
@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    
    @GetMapping("/call")
    public String call(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("mango-producer");
        System.out.println(" address : " +serviceInstance.getUri());
        System.out.println(" address : " +serviceInstance.getServiceId());

        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;

    }
}
