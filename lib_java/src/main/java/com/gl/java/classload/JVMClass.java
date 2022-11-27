package com.gl.java.classload;

// 类的初始化顺序
public class JVMClass extends BaseCodeBlock {
    {
        System.out.println("子类的普通代码块");
    }

    public JVMClass() {
        System.out.println("子类的构造方法");
    }

    @Override
    public void msg() {
        System.out.println("子类的普通方法");
    }

    public static void msg2() {
        System.out.println("子类的静态方法");
    }

    static {
        System.out.println("子类的静态代码块");
    }

    public static void main(String[] args) {
        BaseCodeBlock bcb = new JVMClass();
        bcb.msg();
    }

    Other o = new Other();
}

class BaseCodeBlock {

    public BaseCodeBlock() {
        System.out.println("父类的构造方法");
    }

    public void msg() {
        System.out.println("父类的普通方法");
    }

    public static void msg2() {
        System.out.println("父类的静态方法");
    }

    static {
        System.out.println("父类的静态代码块");
    }

    Other2 o2 = new Other2();

    {
        System.out.println("父类的普通代码块");
    }
}

class Other {
    Other() {
        System.out.println("初始化子类的属性值");
    }
}

class Other2 {
    Other2() {
        System.out.println("初始化父类的属性值");
    }
}
