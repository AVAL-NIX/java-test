package com.zx.framework.context;

/**
 * 通过解耦的方式获得IOC容器的顶层设计
 * 后面将通过一个监听器去扫描所有的类， 只要实现了此接口
 * 将自动调用setApplicationContext()方法， 将ioc容器注入到目标类
 * 观察者模式
 * @author zhengxin
 * @date 2021/3/14
 */
public interface ZXApplicationContextAware {

    void setApplicationContext(ZXApplicationContext applicationContext);
}
