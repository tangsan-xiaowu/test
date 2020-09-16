package com.flyflyyun.tongtech;

import com.alibaba.fastjson.JSON;
import com.tongtech.pojo.Customers;
import com.tongtech.untils.HttpClientUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpTest {

    /**
     * 传送json类型的post请求
     */
    @Test
    public void testPostByJson(){
        String url = "http://192.168.191.128:8080/ssm-test1/customer/find";
       /*
        Map<String, String> params = new HashMap<String, String>();
        params.put("uni_sc_id","");
        params.put("corp_name","上海跃进电机厂");
        String json = JSON.toJSONString(params);*/
        String result = HttpClientUtil.doPostJson(url, "{\"custId\":\"10002\"}");
        System.out.println("返回json"+result);
        List<Customers> customersList = JSON.parseArray(result, Customers.class);
        System.out.println(customersList);
    }

    @Test
    public void testCase(){
        String temp = "111";
        String Temp = "222";
        String IF = "333";
        System.out.println(IF);

    }

}
