package com.tongtech.mapper;

import com.tongtech.pojo.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author: yufeifei
 * @date: 2019-10-28 21:46
 * @version: 1.0
 */
public interface OrderMapper {

    /**
     * 通过status一次拿出5条数据
     * @return
     */
    List<Orders> queryOrdersByStatus();


    /**
     * 批量更新order
     * @param list
     * @return
     */
    Integer updateOrderByOrderNum(List<Integer> list);

}
