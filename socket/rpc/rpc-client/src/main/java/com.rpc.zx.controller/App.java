package com.rpc.zx.controller;

import com.tomcat.controller.IHelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhengxin
 * @date 2021/5/2
 */
public class App {

    public static void main(String[] args) {
//        RpcProxyClient rpcProxyClient = new RpcProxyClient();
//        IHelloService iHelloService = rpcProxyClient.clientProxy(IHelloService.class, "localhost", 8080);
//        String result = iHelloService.sayHello("mic");
//        System.out.println(result);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient bean = context.getBean(RpcProxyClient.class);
        IHelloService iHelloService = bean.clientProxy(IHelloService.class, "localhost", 8080);
        String result = iHelloService.sayHello("mic");
        System.out.println(result);
    }
}
