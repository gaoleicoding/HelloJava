package com.gl.java.deepcopy;

import java.io.Serializable;
import java.util.List;

public class Student implements Cloneable, Serializable {
 
	private String name;
	public List<Address> addressList;
 
	public Student(){
    }
 
	public Student(String name) {
		this.name = name;
	}
 
	public void setName(String name){
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	@Override
	public Object clone() {
		Student student = null;
		try {
			student = (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return student;
	}
}