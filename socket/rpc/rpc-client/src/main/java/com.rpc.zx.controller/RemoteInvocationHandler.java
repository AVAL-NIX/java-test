package com.rpc.zx.controller;

import com.tomcat.controller.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhengxin
 * @date 2021/5/2
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;


    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 代理调用
        System.out.println(" come in ");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        rpcRequest.setVersion("2");
        // 远程网络通信
        RpcNetTransport netTransport = new RpcNetTransport(host,port);

        return netTransport.send(rpcRequest);
    }
}
