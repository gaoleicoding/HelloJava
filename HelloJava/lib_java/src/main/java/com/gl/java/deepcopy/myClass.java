package com.gl.java.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class myClass {

    static List<Student> studentList, copyStudentList;

    public static void main(String[] args) {
        deepCopy2();
    }

    private static void copy() {
        Student student = new Student("李晓东");
        Student student2 = (Student) student.clone();

        println(student.getName());
        println(student2.getName());
        println("改变student2的姓名后--------------");
        student2.setName("张天");
        println(student.getName());
        println(student2.getName());
    }

    private static void copy2() {
        studentList = new ArrayList<>();
        copyStudentList = new ArrayList<>();

        Student student1 = new Student("高磊");
        Student student2 = new Student("明月");
        Student student3 = new Student("腾宇");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        final Object[] array = studentList.toArray();
        if (array != null) {
            for (Object message : array) {
                if (!(message instanceof Student)) {
                    continue;
                }
                copyStudentList.add((Student) message);
            }
        }

        copyStudentList.get(0).setName("***");
        int size = copyStudentList.size();
        for (int i = 0; i < size; i++) {
            Student student = studentList.get(i);
            println(student.getName());
        }
    }

    private static void println(String str) {
        System.out.println(str);
    }

    private static void deepCopy1() {
        studentList = new ArrayList<>();
        copyStudentList = new ArrayList<>();

        Student student1 = new Student("高磊");
        Student student2 = new Student("明月");
        Student student3 = new Student("腾宇");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        for (Student student : studentList) {
            copyStudentList.add((Student) student.clone());
        }

        copyStudentList.get(0).setName("***");
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            Student student = studentList.get(i);
            println(student.getName());
        }
    }

    private static void deepCopy2() {
        studentList = new ArrayList<>();

        Student student1 = new Student("高磊");
        Student student2 = new Student("明月");
        Student student3 = new Student("腾宇");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        copyStudentList=deepCopy(studentList);

        copyStudentList.get(0).setName("***");
        int size = studentList.size();
        for (int i = 0; i < size; i++) {
            Student student = studentList.get(i);
            println(student.getName());
        }
    }
    private static <E> List<E> deepCopy(List<E> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<E> dest = (List<E>) in.readObject();
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<E>();
        }
    }
}