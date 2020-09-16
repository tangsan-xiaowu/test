package com.flyflyyun.tongtech;

import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.junit.Test;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Consumer;

/**
 * @author: yufeifei
 * @date: 2019-12-29 13:37
 * @version: 1.0
 */
public class LambdaTest {

    @Test
    public void test1() {
        //lambda表达式形式：参数，箭头（->）以及表达式
        //1、标准写法，带类型入参，箭头，表达式
        Comparator<String> comp = (String first, String second) -> first.length() - second.length();

        //即使没有参数，仍然需要提供空括号，就像无参数方法
      /*  ()->{
            for (int i = 100;i>=0; i--){
                System.out.println(i);
            }
        }*/

        ActionListener listener = event -> System.out.println("The time is " + new Date());

    }

    @Test
    public void test2() {
        String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Staturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);//按照字典顺序进行排序,sort方法改变原数组
        System.out.println(Arrays.toString(planets));

        //(使用lambda表达式)按照字符串长度进行排序
        Arrays.sort(planets, (first, second) -> first.length() - second.length());

        System.out.println(Arrays.toString(planets));
        //(不使用lambda表达式)
        Arrays.sort(planets, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().length() - o2.toString().length();
            }
        });


        System.out.println(Arrays.toString(planets));

        Timer timer = new Timer(1000, event -> System.out.println("The time is " + new Date()));
        new Timer(1000, System.out::println);
        timer.start();
        System.exit(0);


        Arrays.asList("1", "2", "3");

    }


    @Test
    public void testThread() {
        List<String> list = Arrays.asList("线程1", "线程2", "线程3");
        List<Thread> threads = new ArrayList<>();
        for (String threadName : list) {
            new Thread(() -> {
                System.out.println(threadName + "-->我是范闲！！");
                test3();
            }, threadName).start();
        }
     /* *//*  for (int i = 0; i <threads.size() ; i++) {
            threads.get(i).start();
        }*//*
        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();*/
    }

    @Test
    public void test3() {
        System.out.println("我是方法3");
    }
}
