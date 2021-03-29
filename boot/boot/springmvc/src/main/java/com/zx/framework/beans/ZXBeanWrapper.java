package com.zx.framework.beans;

/**
 * @author zhengxin
 * @date 2021/3/14
 */
public class ZXBeanWrapper {

    // instance 是 beanDefinition
    Object instance = null;

    public ZXBeanWrapper(Object instance) {
        this.instance = instance;
    }

    public Object getWrappedInstance(){
        return this.instance;
    }


    public Class<?> getWrappedClass(){
        return this.instance.getClass();
    }
}
