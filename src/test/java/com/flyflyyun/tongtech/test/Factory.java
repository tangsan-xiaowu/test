package com.flyflyyun.tongtech.test;

/**
 * @author: yufeifei
 * @date: 2020-07-02 11:12
 * @version: 1.0
 */
public class Factory {
    //提供获取对象的方法
    public IUserDao getUserDAO(){
        //返回实例对象
        return new  UserDaoImpl ();
    }
}
