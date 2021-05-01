package com.rpc.controller;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
public class HelloService implements IHelloService {


    @Override
    public String sayHello(String content) {
        System.out.println("  request in : " + content);
        return "Say Hello : " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println(" request in : " + user.toString());
        return "Say Hello : " + user.toString();
    }
}
