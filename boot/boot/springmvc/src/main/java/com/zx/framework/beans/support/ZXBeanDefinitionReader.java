package com.zx.framework.beans.support;

import com.zx.framework.beans.config.ZXBeanDefinition;

import java.beans.beancontext.BeanContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 读取所有的类
 * @author zhengxin
 * @date 2021/3/14
 */
public class ZXBeanDefinitionReader {

    private Properties properties = new Properties();

    public static final String SCAN_PACKAGE = "scanPackage";

    public ZXBeanDefinitionReader(String... sourcesName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(sourcesName[0].replace("classpath:", ""));
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //扫描
        doScanner(properties.getProperty(SCAN_PACKAGE));
    }

    private List<String> classNames = new ArrayList<>();

    private void doScanner(String packageName) {
        //把所有的.替换成/
        URL url = this.getClass().getResource("/" + packageName.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                //递归读取包
                doScanner(packageName + "." + file.getName());
            } else {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }


    public Properties getProperties() {
        return properties;
    }

    public List<ZXBeanDefinition> loadBeanDefinitions() {
        List<ZXBeanDefinition> result = new ArrayList<>();

        try {
            for (String className : classNames) {
                Class<?> beanClass = Class.forName(className);
                //有可能是接口, 如果是一个接口， 用他的实现类
                if (beanClass.isInterface()) {
                    continue;
                }
                ZXBeanDefinition zxBeanDefinition = doCreateBeanDefinition(className, beanClass.getName());
                if (null == zxBeanDefinition) {
                    continue;
                }
                // bean name 有3种情况
                // 1. 默认是类名首字母小写
                // 2. 自定义名字
                // 3. 接口注入
                result.add(zxBeanDefinition);

                Class<?>[] interfaces = beanClass.getInterfaces();
           /*     if(interfaces.length == 0){
                    continue;
                }*/
                for (Class<?> anInterface : interfaces) {
                    //如果是多个实现类。 只能覆盖
                    // ?为什么 ， 因为spring 没那么智能 ， 就是这么傻 , 所以一个接口最好只有一个实现类
                    // 这时候 ， 可以自定义名字
                    result.add(doCreateBeanDefinition(anInterface.getName(), beanClass.getName()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * @param className 类全路径
     * @return
     */
    private ZXBeanDefinition doCreateBeanDefinition(String className, String simpleName) {
        try {

            ZXBeanDefinition zxBeanDefinition = new ZXBeanDefinition();
            zxBeanDefinition.setBeanClassName(className);
            zxBeanDefinition.setFactoryBeanName(simpleName);
            zxBeanDefinition.setLazyInit(false);

            return zxBeanDefinition;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 把字符串的首字母小写
     *
     * @param name
     * @return
     */
    private String toLowerFirstWord(String name) {
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
}
