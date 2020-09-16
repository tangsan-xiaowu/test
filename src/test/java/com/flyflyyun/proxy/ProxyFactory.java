package com.flyflyyun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: yufeifei
 * @date: 2020-09-05 15:53
 * @version: 1.0
 * 动态代理工厂
 */
public class ProxyFactory {

    /**
     *  提供被代理对象和处理器对象，返回代理对象
     * @return 代理对象(具体使用时需要转换成对应接口类型)
     */
    public static Object getProxyObject(Object object,InvocationHandler handler){
        //1、获得被代理对象的类加载器
        ClassLoader classLoader = object.getClass().getClassLoader();

        //2、获得被代理对象的所有接口
        Class<?>[] interfaces = object.getClass().getInterfaces();

        //3、调用处理器对象。
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
