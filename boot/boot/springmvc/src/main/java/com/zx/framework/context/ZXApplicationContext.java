package com.zx.framework.context;

import com.zx.framework.annotation.ZXAutowired;
import com.zx.framework.annotation.ZXController;
import com.zx.framework.annotation.ZXService;
import com.zx.framework.aop.ZXBeanPostProcessor;
import com.zx.framework.beans.ZXBeanFactory;
import com.zx.framework.beans.ZXBeanWrapper;
import com.zx.framework.beans.ZXDefaultListableBeanFactory;
import com.zx.framework.beans.config.ZXBeanDefinition;
import com.zx.framework.beans.support.ZXBeanDefinitionReader;

import java.lang.reflect.Field;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * IOC 主类
 *
 * @author zhengxin
 * @date 2021/3/14
 */
public class ZXApplicationContext extends ZXDefaultListableBeanFactory implements ZXBeanFactory {

    private String[] configLocations;

    ZXBeanDefinitionReader zxBeanDefinitionReader;

    // 单列的IOC容器
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>(16);

    // 通用的IOC容器
    private Map<String, ZXBeanWrapper> factoryBeanInstanceCache = new ConcurrentHashMap<>(16);

    public ZXApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    /**
     * 依赖注入从这里开始
     * 读取beanDefinition
     * 反射创建一个实例返回
     * 通过beanwrapper返回
     * // beanWrapper
     * // 装饰器模式，
     * 我保留原来的OOP关系
     * 我需要对它进行扩展，增强(为以后AOP打基础)
     *
     * @param beanName
     * @return
     */
    @Override
    public Object getBean(String beanName) {

        ZXBeanDefinition zxBeanDefinition = super.beanDefinitionMap.get(beanName);

        // 1. 初始化
        Object instance = instantiateBean(beanName, zxBeanDefinition);

        // 1.2 通知
        ZXBeanPostProcessor zxBeanPostProcessor = new ZXBeanPostProcessor();
        zxBeanPostProcessor.postProcessBeforeInitialization(instance, beanName);
        // 1.3. 封装
        ZXBeanWrapper zxBeanWrapper = new ZXBeanWrapper(instance);
        // 分2个方法 解决 循环依赖的问题。  无法解决 构造器循环注入问题 ， 只能解决set注入问题
        try {
            if (this.factoryBeanInstanceCache.containsKey(beanName)) {
                throw new Exception("bean name  is exists !" + beanName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //1.4 存入IOC容器
        this.factoryBeanInstanceCache.put(beanName, zxBeanWrapper);

        // 2. 注入
        populateBean(beanName, super.beanDefinitionMap.get(beanName), zxBeanWrapper);

        //2.1 后置通知
        zxBeanPostProcessor.postProcessAfterInitialization(instance, beanName);

        return zxBeanWrapper.getWrappedInstance();
    }

    private void populateBean(String beanName, ZXBeanDefinition zxBeanDefinition, ZXBeanWrapper zxBeanWrapper) {
        Object instance = zxBeanWrapper.getWrappedInstance();
        Class<?> clazz = zxBeanWrapper.getWrappedClass();

        // 判断这个实例有没有注解
        if (!clazz.isAnnotationPresent(ZXController.class) || !clazz.isAnnotationPresent(ZXService.class)) {
            return;
        }

        //获取所有字段
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!declaredField.isAnnotationPresent(ZXAutowired.class)) {
                continue;
            }
            ZXAutowired autowired = declaredField.getAnnotation(ZXAutowired.class);
            String autoBeanName = autowired.value().trim();
            if ("".equals(autoBeanName)) {
                autoBeanName = declaredField.getType().getName();
            }

            declaredField.setAccessible(true);

            try {
                declaredField.set(instance, this.factoryBeanInstanceCache.get(autoBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }

    private Object instantiateBean(String beanName, ZXBeanDefinition zxBeanDefinition) {
        // 1. 要拿到实例化的类名
        String beanClassName = zxBeanDefinition.getBeanClassName();

        // 2. 反射
        Object instance = null;
        try {
            if (this.singletonObjects.containsKey(beanClassName)) {
                instance = this.singletonObjects.get(beanClassName);
            } else {
                Class<?> aClass = Class.forName(beanClassName);
                instance = aClass.newInstance();
                this.singletonObjects.put(beanClassName, instance);
                this.singletonObjects.put(zxBeanDefinition.getFactoryBeanName(), instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return instance;
    }

    // 只处理非延迟加载的情况
    private void doAutowrited() throws Exception {
        for (Entry<String, ZXBeanDefinition> stringZXBeanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            ZXBeanDefinition zxBeanDefinition = stringZXBeanDefinitionEntry.getValue();
            if (zxBeanDefinition.isLazyInit()) {
                continue;
            }
            getBean(stringZXBeanDefinitionEntry.getKey());
        }

    }

    private void doRegisterBeanDefinition(List<ZXBeanDefinition> zxBeanDefinitions) {
        for (ZXBeanDefinition zxBeanDefinition : zxBeanDefinitions) {
            super.beanDefinitionMap.put(zxBeanDefinition.getBeanClassName(), zxBeanDefinition);
        }
    }

    @Override
    public void refresh() {
        // 1. 定位， 定位配置文件
        zxBeanDefinitionReader = new ZXBeanDefinitionReader(this.configLocations);

        // 2. 加载配置文件  ， 扫描相关的类 ， 把他们封装成beanDefinition
        List<ZXBeanDefinition> zxBeanDefinitionReaders = zxBeanDefinitionReader.loadBeanDefinitions();

        // 3. 注册， 把配置信息放到容器中    （ 伪IOC容器)
        doRegisterBeanDefinition(zxBeanDefinitionReaders);

        // 4. 把不是延时加载的类， 要提前初始化 。
        try {
            doAutowrited();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String[] getBeanDefinitionNames() {
        return super.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount() {
        return super.beanDefinitionMap.size();
    }
}
