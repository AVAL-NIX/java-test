package com.rpc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
//       IHelloService helloService = new HelloServiceImpl();
//       RpcProxyServer proxyServer = new RpcProxyServer();
//       proxyServer.publisher(helloService, 8080);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.start();
    }

}
