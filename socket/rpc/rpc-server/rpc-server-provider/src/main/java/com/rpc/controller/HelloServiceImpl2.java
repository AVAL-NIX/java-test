package com.rpc.controller;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
@RpcService(value = IHelloService.class, version = "2")
public class HelloServiceImpl2 implements IHelloService {


    @Override
    public String sayHello(String content) {
        System.out.println(" v2  request in sayHello: " + content);
        return " v2 Say Hello  sayHello : " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("v2 request in saveUser: " + user.toString());
        return "v2 Say Hello saveUser : " + user.toString();
    }
}
