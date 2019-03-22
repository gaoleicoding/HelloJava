package com.gaolei.java_lib.mystack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<E> {
	//容器
	private Deque<E> container=new ArrayDeque<E>();
	//容量
	private int cap;
	
	public MyStack(int cap){
		super();
		this.cap=cap;
	}
	
	//压站
	public boolean push(E e){
		if(this.container.size()+1>this.cap){
			return false;
		}
		return this.container.offerLast(e);
		
	}
	
	//弹站
	public E pop(){
		return this.container.pollLast();
	}
	
	//出战
	public E peak(){
		return this.container.peekLast();
	}
	
	public int size(){
		return this.container.size();
	}
	
	public static void main(String[] args) {
		MyStack<String> stack=new MyStack<String>(10);
		stack.push("a");
		stack.push("b");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
 
}
