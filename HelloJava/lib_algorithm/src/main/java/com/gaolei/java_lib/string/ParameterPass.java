package com.gaolei.java_lib.string;

import java.util.Arrays;

/**
 * Description：
 * JAVA不同于C++，Java只有按值传递（基本类型就是通常说的按值传递，对象是传对象引用副本的值，所以也叫按值传递），
 * ch之所以改变是因为它根据ch对象的引用制作了一个引用的副本传给函数，而数组里的元素的改变会引起ch这个数组对象的改变。
 * 另外你要是给函数不传数组，只传单个char，那么就和str一样不会改变了
 *
 * 在java核心技术卷一中有这样的总结： 1、一个方法不能修改一个基本数据类型的参数（即数值型和布尔型）； 2、一个方法可以改变一个对象参数的状态； 3、一个方法不能让对象参数引用一个新的对象。
 */
public class ParameterPass {
    public static void main(String args[]) {
        String str = new String("good");
        char[] chars = {'a', 'b', 'c'};
        User user = new User("gl", 34);
        ParameterPass example = new ParameterPass();
        example.exchange(str, chars, user);
        System.out.print(str + ",");
        System.out.print(Arrays.toString(chars) + ",");
        System.out.print(user.toString());
    }

    private void exchange(String str, char[] chars, User user) {
        str = "test ok";
        chars[0] = 'g';
        user = new User("zmy", 31);
    }


}
