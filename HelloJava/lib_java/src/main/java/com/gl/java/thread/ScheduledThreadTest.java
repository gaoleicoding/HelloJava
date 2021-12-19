package com.gl.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadTest {
    /**
     * 线程安全的队列
     */
    static Queue<String> queue = new ConcurrentLinkedQueue<String>();
 
    static {
        //入队列
        for (int i = 0; i < 9; i++) {
            queue.add("task-" + i);
        }
    }
 
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("时间:" + sdf.format(new Date()) );
        for (int i = 0; i < queue.size(); i++) {
            executor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
 
                    String value = queue.poll();
                    if (value != "" && null != value) {
                        System.out.println("时间:" + sdf.format(new Date())+" 线程" + Thread.currentThread().getName() + " 执行了task: " + value);
                    }
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },  2, 6, TimeUnit.SECONDS);
 
        }
//不注释这行会打印出问题，应该是先执行关闭线程操作了
//        executor.shutdown();
    }
}