package com.zx.framework.webmvc.servlet;

import com.zx.framework.annotation.*;
import com.zx.framework.context.ZXApplicationContext;
import com.zx.framework.util.ServletUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class ZXDispatcherServlet extends HttpServlet {

    public static final String CONTEXT_CONFIG = "classpath:application.properties";

    private ZXApplicationContext context;

    private List<HandlerMapping> handlerMappings;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟九大组件初始化
        System.out.println(" spring mvc 初始化开始");
        // 初始化applicationContext
        context = new ZXApplicationContext(CONTEXT_CONFIG);

        // 2. 初始化9大组件
        initStrategies(context);

        System.out.println(" spring mvc 初始化结束");
    }



    protected void initStrategies(ZXApplicationContext context) {
        initMultipartResolver(context);
        initLocaleResolver(context);
        initThemeResolver(context);
        //TODO
        initHandlerMappings(context);
        //TODO
        initHandlerAdapters(context);
        initHandlerExceptionResolvers(context);
        initRequestToViewNameTranslator(context);

        //TODO
        initViewResolvers(context);
        initFlashMapManager(context);
    }

    private void initFlashMapManager(ZXApplicationContext context) {

    }

    private void initViewResolvers(ZXApplicationContext context) {

    }

    private void initRequestToViewNameTranslator(ZXApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(ZXApplicationContext context) {

    }

    private void initHandlerAdapters(ZXApplicationContext context) {

    }

    private void initHandlerMappings(ZXApplicationContext context) {

        String[] beanDefinitionNames = context.getBeanDefinitionNames();


        for (String beanDefinitionName : beanDefinitionNames) {
            Object controller = context.getBean(beanDefinitionName);

            Class<?> clazz = controller.getClass();

            if(!clazz.isAnnotationPresent(ZXController.class)){
                if (!clazz.isAnnotationPresent(ZXController.class))
                {
                    continue;
                }
                //获取控制器类名
                String controllerName = ServletUtils.toLowerFirstWord(clazz.getSimpleName());
                if(!clazz.getAnnotation(ZXController.class).value().equals("")){
                    controllerName = clazz.getAnnotation(ZXController.class).value();
                }

                //拼url时,是controller头的url拼上方法上的url
                String baseUrl = "";
                if (clazz.isAnnotationPresent(ZXRequestMapping.class))
                {
                    ZXRequestMapping annotation = clazz.getAnnotation(ZXRequestMapping.class);
                    baseUrl = annotation.value();
                }
                Method[] methods = clazz.getMethods();
                for (Method method : methods)
                {
                    if (!method.isAnnotationPresent(ZXRequestMapping.class))
                    {
                        continue;
                    }
                    ZXRequestMapping annotation = method.getAnnotation(ZXRequestMapping.class);
                    String url = annotation.value();

                    url = (baseUrl + "/" + url).replaceAll("/+", "/");
                    //这里必须从beans 里面拿 因为里面已经有service实例
                    System.out.println(url + "," + method);
                }

            }

        }
    }

    private void initThemeResolver(ZXApplicationContext context) {

    }

    private void initLocaleResolver(ZXApplicationContext context) {
    }

    private void initMultipartResolver(ZXApplicationContext context) {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //处理请求
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500!! Server Exception");
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) {
    }


}
