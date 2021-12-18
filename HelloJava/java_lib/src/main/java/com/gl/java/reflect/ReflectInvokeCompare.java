package com.gl.java.reflect;

import java.lang.reflect.Method;

/*
 * setAccessible（true/false）：表示启用和禁用安全检查的开关。
 * 当值为true时，指反射对象在使用时应该取消java语言访问检查，值为false则只是反射的对象应该试试java语言访问检查。
 * 当值设置为true时，不接受检查，可以提高反射的运行速度。
 */
public class ReflectInvokeCompare {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {


        User u = new User();
        Class clazz = u.getClass();

        //第一种，直接调用
        long start1 = System.currentTimeMillis();
        for (long i = 0; i < 1000000; i++) {
            u.setName("张三");
        }
        long end1 = System.currentTimeMillis();
        System.out.println("直接调用方法的时间：" + (end1 - start1) + "ms");

        //第二种

        long start2 = System.currentTimeMillis();
        try {
            for (long i = 0; i < 1000000; i++) {
                Method method = clazz.getDeclaredMethod("setName", String.class);
                method.invoke(u, "张三");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        long end2 = System.currentTimeMillis();

        System.out.println("不加setAccessible(true)调用方法的时间：" + (end2 - start2) + "ms");


        //第三种
        long start3 = System.currentTimeMillis();
        try {
            for (long i = 0; i < 1000000; i++) {
                Method method = clazz.getDeclaredMethod("setName", String.class);
                method.setAccessible(true);
                method.invoke(u, "张三");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        long end3 = System.currentTimeMillis();
        System.out.println("加了setAccessible(true)调用方法，跳过安全检查后执行的的时间：" + (end3 - start3) + "ms");
    }

}