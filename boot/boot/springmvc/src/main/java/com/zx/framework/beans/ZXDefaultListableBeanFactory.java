package com.zx.framework.beans;

import com.zx.framework.beans.config.ZXBeanDefinition;
import com.zx.framework.context.ZXAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhengxin
 * @date 2021/3/14
 */
public class ZXDefaultListableBeanFactory extends ZXAbstractApplicationContext {

    //存放bean 就是IOC中所有的bean   KEY: 非全限定名(bean的名字)
    protected final Map<String, ZXBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public void refresh() {

    }
}
