package com.elevysi.essentials;

public class Queue {
	public static class QueueNode<T>{
		int data;
		QueueNode next;
		
		public QueueNode(int d){
			this.data = d;
		}
	}
	
	QueueNode first;
	QueueNode last;
	
	public QueueNode remove(){
		QueueNode tmp = first;
		first = first.next;
		return tmp;
	}
	
	public void add(QueueNode n){
		last.next = n;
		last = n;
	}
	
	public boolean isEmpty(){
		return first == null? true : false;
	}
}
