package com.flyflyyun.proxy;

/**
 * @author: yufeifei
 * @date: 2020-09-05 16:55
 * @version: 1.0
 */
public class CustomerImpl implements ICustomer {

    @Override
    public void save() {
        System.out.println("用户保存成功");
    }
}
