package com.tomcat.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhengxin
 * @date 2021/5/2
 */

public class GpRpcServer implements ApplicationContextAware, InitializingBean {

    ExecutorService executorService = Executors.newCachedThreadPool();

    private int port;

    private Map<String, Object> handMap = new HashMap<>();

    public GpRpcServer(int port) {
        this.port = port;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(handMap, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(RpcService.class);
        if (!serviceBeanMap.isEmpty()) {
            serviceBeanMap.forEach((s, o) -> {
                //拿到注解
                RpcService rpcService = o.getClass().getAnnotation(RpcService.class);
                //拿到注解的values()
                String name = rpcService.value().getName();
                String version = rpcService.version();
                if(!StringUtils.isEmpty(version)){
                    name +="-" + version;
                }
                //存放方便调用
                handMap.put(name, o);
            });
        }


    }
}
