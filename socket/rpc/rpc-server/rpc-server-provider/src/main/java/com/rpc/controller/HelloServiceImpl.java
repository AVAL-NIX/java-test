package com.rpc.controller;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
@RpcService(IHelloService.class)
public class HelloServiceImpl implements IHelloService {


    @Override
    public String sayHello(String content) {
        System.out.println("v1  request in sayHello: " + content);
        return "v1 Say Hello  sayHello : " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("v1 request in saveUser: " + user.toString());
        return "v1 Say Hello saveUser : " + user.toString();
    }
}
