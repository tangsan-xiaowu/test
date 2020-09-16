package com.flyflyyun.proxy;

/**
 * @author: yufeifei
 * @date: 2020-09-05 16:58
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        CustomerImpl customer = new CustomerImpl(); //被代理对象
        //动态代理返回的对象必须使用对应的接口类型类接收.
        ICustomer proxy =  (ICustomer)ProxyFactory.getProxyObject(customer, new MyInvocationHandler(customer));
        proxy.save();
    }
}
