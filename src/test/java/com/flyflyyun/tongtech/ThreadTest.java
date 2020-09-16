package com.flyflyyun.tongtech;

import org.junit.Test;

import java.util.*;

/**
 * @author: yufeifei
 * @date: 2020-02-12 17:16
 * @version: 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<String> dataList = new ArrayList<>();
        int i = 0;
        while (i < 100) {
            dataList.add(i + "");
            i++;
        }

        MakeSignTask makeSignTask = new MakeSignTask(dataList);
        makeSignTask.setStart(start);
        //创建3个线程去跑
        Thread thread1 = new Thread(makeSignTask, "线程1");
        Thread thread2 = new Thread(makeSignTask, "线程2");
        Thread thread3 = new Thread(makeSignTask, "线程3");

        //启动
        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Test
    public void stringTest() {
        String str1 = "yufeifei";
        String str2 = "yufeifei";
        String str3 = new String("yufeifei");
        String str4 = "yufei";
        String str5 = "fei";
        String str6 = "yufei" + "fei";
        String str7 = str4 + str5;
        System.out.println(str1 + "<->" + str2 + "<->" + str3);
        /*==变量直接比较内存地址*/
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
        System.out.println();
        System.out.println(str1 == str6);
        System.out.println(str6 == str7);

        char[] arr = {'a', 'b', 'c'};
        System.out.println(arr);
    }

    @Test
    public void compareTest() {
        List<Integer> list = Arrays.asList(10, 5, 3, 227, 27);
        Integer max = 0;
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                j=i;
            }
        }
        System.out.println(j+" "+max);
    }

    @Test
    public void compareDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1900,0,1);
        System.out.println(calendar.getTimeInMillis()+"   "+new Date().getTime());
        if(calendar.getTimeInMillis()>new Date().getTime()){
            System.out.println("lalaalla");
        }
    }

    @Test
    public void test1(){
        int number = -98;
        boolean result = number > 0 || number < 100;

        System.out.println(result);
    }


    //对于一个有多个数值的数组，只有一个是唯一的，其他都是成对的，怎样快速找到这个唯一值
    @Test
    public void test2(){
        int[] numarry = new int[]{2,3,2,5,3,1,1};
        int one=-1;
        Set<Integer> tempList = new HashSet<>();
        for (int i = 0; i < numarry.length-1; i++) {
            if(tempList.contains(numarry[i])){
                //忽略相同值的索引
                continue;
            }
            boolean flag = true;
            for (int j = i+1; j < numarry.length; j++) {
                if(numarry[i]==numarry[j]){
                    flag = false;
                    tempList.add(numarry[i]);
                }
            }
            if(flag==true){
                one = i;
            }
        }
        if(one!=-1){
            System.out.println("是唯一的值是："+numarry[one]);
        }else {
            System.out.println("是唯一的值是："+numarry[numarry.length-1]);
        }

        System.out.println(tempList);
    }
    @Test
    public void test3(){
        int[] numarry = new int[]{2,3,2,5,3,1,1};
        int aim=numarry[0] ;
        for (int i = 1; i < numarry.length; i++) {
            aim = aim ^ numarry[i];
        }
        System.out.println(aim);
    }
    @Test
    public void test4(){
        System.out.println(2^3^5^5^2);
    }



}
