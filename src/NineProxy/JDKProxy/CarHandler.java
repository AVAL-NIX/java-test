package NineProxy.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JDK 代理类
 *
 * @author zx
 * @date 2019/6/25
 */
public class CarHandler implements InvocationHandler {

    public CarHandler(Object o) {
        this.o = o;
    }

    private Object o;

    /**
     * 被代理的参数
     *
     * @param proxy 被代理的对象
     * @param method 被代理的方法
     * @param args 额外参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        long btime = System.currentTimeMillis();

        System.out.println("  开始行驶 !");

        try {
            method.invoke(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }

        long etime = System.currentTimeMillis();

        System.out.println("用时 : " + (etime - btime));
        return null;
    }
}