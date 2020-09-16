package com.flyflyyun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: yufeifei
 * @date: 2020-09-05 16:34
 * @version: 1.0
 * 代理的处理器对象
 */
public class MyInvocationHandler implements InvocationHandler {

    private CustomerImpl customer;

    public MyInvocationHandler(CustomerImpl customer){
        this.customer = customer;
    }

    /**
     *
     * @param proxy  代理对象
     * @param method 当前执行的方法
     * @param args   当前执行方法的实际参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("save")){
            if(iflogin()){
                method.invoke(customer,args);
                System.out.println("拦截的方法已经处理完毕！");
                return null;
            }
        }
        return null;
    }

    //判断是否登录的方法
    public Boolean iflogin(){
        System.out.println("当前方法成功登录");
        return true;
    }
}
