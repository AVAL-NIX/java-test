package com.rpc.zx.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengxin
 * @date 2021/5/2
 */
@Configuration
public class SpringConfig {

    @Bean(name="rpcProxyClient")
    public RpcProxyClient gpRpcServer(){
        return new RpcProxyClient();
    }

}
