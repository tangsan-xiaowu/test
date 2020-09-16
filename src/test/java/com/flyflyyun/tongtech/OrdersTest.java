package com.flyflyyun.tongtech;

import com.tongtech.mapper.OrderMapper;
import com.tongtech.pojo.Orders;
import com.tongtech.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yufeifei
 * @date: 2019-10-28 21:56
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-mybatis.xml"})
public class OrdersTest {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @Test
    public void queryOrdersByStatusTest(){
        List<Orders> orders = orderMapper.queryOrdersByStatus();
        System.out.println(orders);
    }

    @Test
    public void updateOrderByOrderNumTest(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(20007);
        list.add(20008);
        orderMapper.updateOrderByOrderNum(list);
    }

    @Test
    public void updateOrdersByInterfaceTest(){
        orderService.updateOrdersByInterface();
    }

}
