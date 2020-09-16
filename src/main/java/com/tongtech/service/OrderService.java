package com.tongtech.service;

import com.alibaba.fastjson.JSON;
import com.tongtech.mapper.OrderMapper;
import com.tongtech.pojo.Customers;
import com.tongtech.pojo.Orders;
import com.tongtech.untils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: yufeifei
 * @date: 2019-10-28 21:46
 * @version: 1.0
 */
@Service
public class OrderService {

    private static final String URL = "http://192.168.191.128:8080/ssm-test1/customer/find";
    private static  final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private OrderMapper orderMapper;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void updateOrdersByInterface(){

        //当前线程名：
        String threadName = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();
        LOGGER.info(threadName+"->该方法开始时间：[{}]",sdf.format(new Date(startTime)));
        List<Orders> orders = orderMapper.queryOrdersByStatus();

        //list存放待更新的订单id
        List<Integer> list = new ArrayList<Integer>();
        for (Orders order : orders) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("custId",order.getCustId());
            String json = JSON.toJSONString(params);
            LOGGER.info(threadName+"->转换的json：[{}]",json);
            String result = HttpClientUtil.doPostJson(URL, json);
            LOGGER.info(threadName+"->调接口的结果：[{}]",result);
            List<Customers> customersList = JSON.parseArray(result, Customers.class);
            for (Customers customers : customersList) {
                if(customers!=null){
                    list.add(order.getOrderNum());
                }
            }
        }

        LOGGER.info(threadName+"->待更新的订单id：[{}]",list);

        //根据订单ID进行批量更新
        try {
            //故意延迟5秒
            //Thread.sleep(2000);
            orderMapper.updateOrderByOrderNum(list);
            LOGGER.info(threadName+"->更新成功！！！");
            long endTime = System.currentTimeMillis();
            LOGGER.info(threadName+"->该方法结束时间：[{}]",sdf.format(new Date(endTime)));
            LOGGER.info(threadName+"->执行该方法时间共花费：[{}] 秒",(endTime-startTime)*1.0/1000);
            System.out.println("--------------------------------华丽的分割线----------------------------------------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            LOGGER.error(threadName+"->更新失败！！！:[{}]",e);
            e.printStackTrace();

        }

    }
}
