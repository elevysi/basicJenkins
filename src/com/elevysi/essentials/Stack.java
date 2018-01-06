package com.elevysi.essentials;

public class Stack {
	public static class StackNode<T>{
		int data;
		StackNode<T> next;
		
		public StackNode(int d){
			this.data = d;
		}
	}
	
	StackNode top;
	
	public int pop() throws Exception{
		if(top == null) throw new Exception();
		int item = top.data; 
		top = top.next;
		return item;
	}
	
	public void push(StackNode n) throws Exception{
		if(top != null){
			StackNode tmp = top;
			top = n;
			n.next = tmp;
		}else top = n;
	}
}
