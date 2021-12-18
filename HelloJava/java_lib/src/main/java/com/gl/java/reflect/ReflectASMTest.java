package com.gl.java.reflect;

import com.esotericsoftware.reflectasm.MethodAccess;

import java.lang.reflect.Method;

/*
 * MethodAccess的执行过程：
 * 1.反射Demo.class获取公共非静态方法
 * 2.用ASM技术动态生成新的继承于MethodAccess的类DemoMethodAccess
 * 3.在私有变量内记录方法名称参数等信息
 * 4.在类的invoke方法内实现调用不同的方法
 */
public class ReflectASMTest {

    public static void main(String[] args) throws Exception {
        testJdkReflect();
        testReflectAsm();
    }

    public static void testJdkReflect() throws Exception {
        User someObject = new User();
        Method method = User.class.getMethod("setName", String.class);
        for (int i = 0; i < 5; i++) {
            long begin = System.currentTimeMillis();
            for (int j = 0; j < 100000000; j++) {
                method.invoke(someObject, "Unmi");
            }
            System.out.print(System.currentTimeMillis() - begin + " ");
        }
    }

    public static void testReflectAsm() {
        User someObject = new User();
        MethodAccess access = MethodAccess.get(User.class);
        for (int i = 0; i < 5; i++) {
            long begin = System.currentTimeMillis();
            for (int j = 0; j < 100000000; j++) {
                access.invoke(someObject, "setName", "Unmi");
            }
            System.out.print(System.currentTimeMillis() - begin + " ");
        }
    }
}