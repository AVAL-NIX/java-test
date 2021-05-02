package com.rpc.zx.controller;

import java.lang.reflect.Proxy;

/**
 * @author zhengxin
 * @date 2021/5/2
 */
public class RpcProxyClient {


    public <T> T clientProxy(final Class<T> interfaceCls, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
