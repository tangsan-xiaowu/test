package com.flyflyyun.tongtech;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yufeifei
 * @date: 2020-02-12 17:21
 * @version: 1.0
 */
public class MakeSignTask implements Runnable {
    private List dataList;

    private Set<String> resultList = new HashSet();

    private int num;

    private Boolean flag = false;

    //开始时间
    private long start;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }


    public MakeSignTask() {
    }

    public MakeSignTask(List dataList) {
        if (dataList.size() > 0) {
            this.dataList = dataList;
            num = dataList.size() - 1;
        }
    }

    @Override
    public void run() {
        while (true) {
            if (dataList.size() > 0) {
                /*synchronized (this)*/ {
                    if (num > -1) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "-->调接口制证成功！！！" + num);
                        if(num>-1){
                            resultList.add(dataList.get(num).toString());
                            num--;
                        }else {
                            break;
                        }

                    } else {
                        if (flag == false) {
                            System.out.println(Thread.currentThread().getName() + "  " + resultList.size() + ":" + resultList);
                            long end = System.currentTimeMillis();
                            System.out.println("本次制证共花费"+(end-start)/1000+"秒！");
                            flag = true;
                        }
                        break;
                    }
                }

            }
        }
    }
}
