package NineProxy.JDKProxy;

import NineProxy.SaticProxy.Car;
import NineProxy.SaticProxy.MoiveAble;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zx
 * @date 2019/6/25
 */
public class JDKMain {

    public static void main(String[] args) {
        Car car = new Car();

        InvocationHandler h = new CarHandler(car);

        Class<?> cls = car.getClass();
        /**
         * loader 类加载器 interface 实现的接口 h invocationHandler 实现代理类的对象
         *
         */
        MoiveAble m = (MoiveAble)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);

        m.moive();

    }
}
