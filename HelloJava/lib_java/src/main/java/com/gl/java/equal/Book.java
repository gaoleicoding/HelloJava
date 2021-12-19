package com.gl.java.equal;

import androidx.annotation.Nullable;

import com.gl.java.deepcopy.Student;

public class Book implements Cloneable {
    private String name;
    private String desc;
    private int id;

    public Book(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.id == book.id;
        }
        return super.equals(obj);
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        Book bean = null;
        try {
            bean = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", id=" + id +
                '}';
    }
}