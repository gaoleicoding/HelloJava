package com.gl.algorithm.stack;

public class Array2Stack {
	private int top;
	private int capacity;
	private Object [] array;
	public Array2Stack(){
		top=-1;//栈顶指针为-1
		capacity=5;//初始化容量的大小
		array=new Object[capacity];//初始化数组
	}
	
	public boolean isEmpty(){//判断是否为空
		return top==-1;
	}
	
	public boolean isFull(){//判断是否是满栈的
		return top==capacity-1;
	}
	
	public void push(Object data){//入栈操作
		if(isFull()){
			System.out.println("栈已经满，插入失败");
			return;
		}
		array[++top]=data;
	}
	
	public Object pop(){//返回栈顶元素，并且删除
		Object data=0;
		 if(isEmpty()){
			 System.out.println("栈为空，返回-1");
			 data=-1;
		 }
		 data=array[top--];
		 return data;
	}
	
	public Object top(){//返回栈顶元素，但是不删除
		return array[top];
	}
	
	public int size(){//返回栈顶元素，但是不删除
		return top;
	}
	
	public void showAll(){//显示栈中所有的值 
		for(int i=top;i>=0;i--){
			System.out.print(" "+array[i]);
		}
	}
	public static void main(String[] args) {
		Array2Stack stack=new Array2Stack();
		stack.push(1);
		stack.push(2);
		stack.showAll();
	}
}