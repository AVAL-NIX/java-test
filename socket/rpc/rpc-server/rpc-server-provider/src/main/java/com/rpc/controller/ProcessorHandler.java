package com.rpc.controller;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @author zhengxin
 * @date 2021/5/1
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;
    //实例对象
    private Map<String, Object> handMap;

    public ProcessorHandler(Map server, Socket socket) {
        this.socket = socket;
        this.handMap = server;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;


        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            //输入流 ， 数据呗。 。。 。
            RpcRequest request = (RpcRequest) objectInputStream.readObject();
            Object result = invoke(request);

            //输出
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 反射调用
     *
     * @param request
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private Object invoke(RpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //整理版本号
        String serviceName = request.getClassName();
        String version = request.getVersion();
        if(!StringUtils.isEmpty(version)){
            serviceName +="-" + version;
        }

        Object service = handMap.get(serviceName);
        if(service == null){
            throw new RuntimeException(" service not found : "+ serviceName);
        }
        Object[] args = request.getParameters();
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        Class clazz = Class.forName(request.getClassName()); // 有可能是一个impl
        // 根据方法名+形参 找到方法
        Method method = clazz.getMethod(request.getMethodName(), types);

        Object result = method.invoke(service, args);
        return result;
    }
}
