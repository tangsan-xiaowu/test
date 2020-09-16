package com.tongtech.controllers;

import java.io.*;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @author: yufeifei
 * @date: 2019-11-10 14:31
 * @version: 1.0
 */
public class JSONTest {
    private static  String filePath ;

    private static  String filePath1 ;//更新2

    static {
        try {
             filePath = JSONTest.class.getClassLoader().getResource("timestamp.properties").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    private static final Properties PROPERTIES = new Properties();

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        PROPERTIES.load(reader);
        System.out.println("改变前的timestamp值："+PROPERTIES.getProperty("timestamp"));
        reader.close();
        PROPERTIES.setProperty("timestamp",DATE_FORMAT.format(new java.sql.Date(System.currentTimeMillis())));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath)); //默认是覆盖文件内容
        PROPERTIES.store(bufferedWriter,"改变");
        bufferedWriter.close();
    }



}
