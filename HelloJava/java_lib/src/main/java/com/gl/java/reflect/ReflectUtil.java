package com.gl.java.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * MethodAccess的执行过程：
 * 1.反射Demo.class获取公共非静态方法
 * 2.用ASM技术动态生成新的继承于MethodAccess的类DemoMethodAccess
 * 3.在私有变量内记录方法名称参数等信息
 * 4.在类的invoke方法内实现调用不同的方法
 */
public class ReflectUtil {

    public static void main(String[] args) throws Exception {


    }

    public void constructorReflect() throws Exception {
        Class userClass = User.class;

        Constructor userConstructor1 = userClass.getConstructor(String.class, int.class); //有参构造器
        User user1 = (User) userConstructor1.newInstance("小红", 18);
        System.out.println(user1.toString());

        Constructor userConstructor2 = userClass.getConstructor();                          //无参构造器
        User user2 = (User) userConstructor2.newInstance();
        System.out.println(user2);

        Constructor userConstructor3 = userClass.getDeclaredConstructor(String.class);      //私有构造器
        userConstructor3.setAccessible(true);                                               //因为是私有字段，必须开启访问权限
        User user3 = (User) userConstructor3.newInstance("小明");
        System.out.println(user3);
    }

    public void methodReflect() throws Exception {
        Class userClass = User.class;
        User user = (User) userClass.newInstance();                           //用默认无参数构造方法创建对象

        Method method = userClass.getMethod("say", String.class);             //获取名为"say",参数为string的method对象
        method.invoke(user, "hello");                                         //调用user的say方法
    }

    public void fieldReflect() throws Exception {
        Class userClass = User.class;
        Constructor userConstructor = userClass.getConstructor(String.class, int.class);
        User user = (User) userConstructor.newInstance("小明", 18);

        System.out.println(user.toString());

        Field userField = userClass.getDeclaredField("username");  //获取username字段
        userField.setAccessible(true);                             //因为是私有字段，所以必须解除访问限制
        userField.set(user, "小红");                                //给user对象的该字段设置值

        System.out.println(user.toString());
    }
}