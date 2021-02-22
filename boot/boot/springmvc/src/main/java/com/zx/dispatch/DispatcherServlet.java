package com.zx.dispatch;

import com.zx.annation.Autowired;
import com.zx.annation.Controller;
import com.zx.annation.RequestMapping;
import com.zx.annation.RequestParam;
import com.zx.annation.Service;

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

public class DispatcherServlet extends HttpServlet {
    private Properties properties = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String, Object> beans = new HashMap<>();

    private Map<String, Method> handlerMapping = new HashMap<>();

    private Map<String, Object> controllerMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        //模拟九大组件初始化
        System.out.println(" spring mvc 初始化开始");
        //第1大组件 1.加载配置文件
        initLoadConfig(config.getInitParameter("contextConfigLocation"));

        //2.初始化所有相关联的类,扫描用户设定的包下面所有的类 (需要依赖注入的类)
        doScanner(properties.getProperty("scanPackage"));

        //3.拿到扫描到的类,通过反射机制,实例化,并且放到ioc容器中(k-v  beanName-bean) beanName默认是首字母小写
        doInstance();

        // 4.将IOC容器中的service对象设置给controller层定义的field上
        doIoc();

        //第4大组件 .初始化HandlerMapping(将url和method对应上)
        initHandlerMappings();

        System.out.println(" spring mvc 初始化结束");
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

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            try {
                //把类搞出来,反射来实例化(只有加@Controller需要实例化)
                Class<?> clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(Controller.class)) {
                    Controller controller = clazz.getAnnotation(Controller.class);
                    if (controller.value().equals("")) {
                        beans.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
                    } else {
                        beans.put(controller.value(), clazz.newInstance());
                    }
                } else if (clazz.isAnnotationPresent(Service.class)) {
                    Service service = clazz.getAnnotation(Service.class);
                    if (service.value().equals("")) {
                        beans.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
                    } else {
                        beans.put(service.value(), clazz.newInstance());
                    }
                } else {
                    continue;
                }

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /**
     * 依赖注入
     */
    private void doIoc() {
        if (beans.isEmpty()) {
            System.out.println("beans is null");
            return;
        }
        for (Map.Entry<String, Object> map : beans.entrySet()) {
            //IOC实例 , key是描述,也有可能是类名
            Object instance = map.getValue();

            //获取类
            Class<?> clazz = instance.getClass();

            if (clazz.isAnnotationPresent(Controller.class)) {
                //获取成员变量
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        Autowired requestParam = field.getAnnotation(Autowired.class);
                        String value = requestParam.value();
                        //未设置值则用类名
                        if ("".equals(value)) {
                            value = field.getName();
                        }
                        // 由于此类成员变量设置为private，需要强行设置
                        field.setAccessible(true);
                        try {
                            field.set(instance, beans.get(value));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (clazz.isAnnotationPresent(Service.class)) {
                //获取成员变量
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        Autowired requestParam = field.getAnnotation(Autowired.class);
                        String value = requestParam.value();
                        //未设置值则用类名
                        if ("".equals(value)) {
                            value = field.getName();
                        }
                        // 由于此类成员变量设置为private，需要强行设置
                        field.setAccessible(true);
                        try {
                            field.set(instance, beans.get(value));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void doScanner(String packageName) {

        //把所有的.替换成/
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
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

    /**
     * 处理请求
     *
     * @param req
     * @param resp
     * @throws Exception
     */
    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        if (handlerMapping.isEmpty()) {
            return;
        }

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();

        url = url.replace(contextPath, "").replaceAll("/+", "/");

        System.out.println(" request url : " + url);
        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 URL NOT FOUND!");
            return;
        }

        Method method = this.handlerMapping.get(url);

        //获取方法的参数列表
        Class<?>[] parameterTypes = method.getParameterTypes();

        //获取请求的参数
        Map<String, String[]> parameterMap = req.getParameterMap();

        //保存参数值
        Object[] paramValues = new Object[parameterTypes.length];

        //获取方法的参数注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        //方法的参数列表
        // 这是其实已经是适配器 HandlerAdapter ,  这块比较复杂 , 这里简写了
        for (int i = 0; i < parameterTypes.length; i++) {
            //根据参数名称，做某些处理
            String requestParam = parameterTypes[i].getSimpleName();

            //获取注解
            Annotation[] annotations = parameterAnnotations[i];

            if (requestParam.equals("HttpServletRequest")) {
                //参数类型已明确，这边强转类型
                paramValues[i] = req;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")) {
                paramValues[i] = resp;
                continue;
            }
            //请求的参数遍历
            for (Entry<String, String[]> param : parameterMap.entrySet()) {
                //方法参数列表
                for (Annotation annotation : annotations) {
                    //参数名
                    String paramName = "";
                    if (annotation instanceof RequestParam) {
                        RequestParam p = (RequestParam) annotation;
                        paramName = p.value();

                    }
                    if ("".equals(paramName)) {
                        //如果没有匹配上注解, 则根据名字来 , 这里太复杂了涉及到JAVA字节码了. 不写了
                    }

                    //如果匹配上了
                    if (paramName.equals(param.getKey())) {
                        if (requestParam.equals("String")) {
                            //给定值
                            String value =
                                    Arrays.toString(param.getValue()).replaceAll("\\[|\\]", "").replaceAll(",\\s", ",");
                            paramValues[i] = value;
                        }
                    }
                }
            }

        }
        //利用反射机制来调用
        try {
            method.invoke(this.controllerMap.get(url), paramValues);//第一个参数是method所对应的实例 在ioc容器中
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 扫描所有的requestMapping注解,获取到请求路径
     */
    private void initHandlerMappings() {

        if (beans.isEmpty()) {
            return;
        }
        try {
            for (Entry<String, Object> entry : beans.entrySet()) {
                Class<? extends Object> clazz = entry.getValue().getClass();
                if (!clazz.isAnnotationPresent(Controller.class)) {
                    continue;
                }
                //获取控制器类名
                String controllerName = toLowerFirstWord(clazz.getSimpleName());
                if (!clazz.getAnnotation(Controller.class).value().equals("")) {
                    controllerName = clazz.getAnnotation(Controller.class).value();
                }

                //拼url时,是controller头的url拼上方法上的url
                String baseUrl = "";
                if (clazz.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
                    baseUrl = annotation.value();
                }
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (!method.isAnnotationPresent(RequestMapping.class)) {
                        continue;
                    }
                    RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                    String url = annotation.value();

                    url = (baseUrl + "/" + url).replaceAll("/+", "/");
                    handlerMapping.put(url, method);
                    //这里必须从beans 里面拿 因为里面已经有service实例
                    controllerMap.put(url, beans.get(controllerName));
                    System.out.println(url + "," + method);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 初始化配置文件
     *
     * @param contextConfigLocation
     */
    private void initLoadConfig(String contextConfigLocation) {
        //把web.xml中的contextConfigLocation对应value值的文件加载到流里面
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            //用Properties文件加载文件里的内容
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != resourceAsStream) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
