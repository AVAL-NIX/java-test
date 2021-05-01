package com.rpc.controller;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
public interface IHelloService {

    String sayHello(String content);


    String saveUser(User user);
}
