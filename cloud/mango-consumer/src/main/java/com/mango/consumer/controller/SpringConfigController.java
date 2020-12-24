package com.mango.consumer.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SpringConfigController {



    @Value("${egc.comm.server.host}")
    private String hello2;

    @RequestMapping("/hello")
    public String from() {
        return this.hello2 + " ===== " + this.hello2;
    }

}
