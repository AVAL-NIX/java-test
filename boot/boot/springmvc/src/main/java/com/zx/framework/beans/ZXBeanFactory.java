package com.zx.framework.beans;

/**
 * @author zhengxin
 * @date 2021/3/14
 */
public interface ZXBeanFactory {


    Object getBean(String beanName) throws Exception;
}
