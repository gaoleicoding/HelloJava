package com.gl.java.classload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    /**
     * @param args
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // TODO Auto-generated method stub
        if (args.length == 0) {
            System.out.println("没有类啊");
        }
        // 取出第一个参数，就是需要运行的类
        String procressClass = args[0];
        // 剩余参数为运行目标类的参数，将这些参数复制到一个新数组中
        String[] procress = new String[args.length - 1];
        System.arraycopy(args, 1, procress, 0, procress.length);
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> class1 = myClassLoader.loadClass(procressClass);
        Method main = class1.getMethod("main", (new
                String[0]).getClass());
        Object argsArray[] = {procress};
        main.invoke(null, argsArray);
    }

    /**
     * @TODO 读取文件内容
     */
    public byte[] getBytes(String fileName) {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try {
            FileInputStream fileInputStream =
                    new FileInputStream(file);
            try {
                int r = fileInputStream.read(raw);
                fileInputStream.close();
                if (r != len)
                    throw new IOException("fail to read the file...");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return raw;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @TODO 编译java文件
     */
    public boolean complie(String javaFile) {
        System.out.println("正在编译...");
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("javac " + javaFile);
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int result = process.exitValue();
        return result == 0;
    }

    /**
     * @TODO 关键，重写findClass方法
     */
    @Override
    protected Class<?> findClass(String arg0) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        Class<?> class1 = null;
        String filePath = arg0.replaceAll(".", "/");
        String className = filePath + ".class";
        String javaName = filePath + ".java";
        File javaFile = new File(javaName);
        File classFile = new File(className);
        if (javaFile.exists()
                && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {
            if (!complie(javaName) || !classFile.exists()) {
                throw new ClassNotFoundException(javaName + " Class找不到");
            }
        }
        if (classFile.exists()) {
            byte[] raw = getBytes(className);
            class1 = defineClass(arg0, raw, 0, raw.length);
        }

        if (class1 == null) {
            throw new ClassNotFoundException(javaName + " 加载失败");
        }

        return class1;
    }

}