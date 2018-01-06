package com.elevysi.essentials;

public class Node {
	
	public int data;
	public Node next;
	
	public Node(int d){
		this.data = d;
	}
	
	void appendToTail(int d){
		Node n = new Node(d);
		Node current = this;
		
		while(current.next != null){
			current = current.next;
		}
		
		current.next = n;
	}
	
	Node deleteNode(Node head, int d){
		//Check if head
		if(head.data == d){
			return head.next;
		}
		Node n = this;
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
				return head;
			}
			 n = n.next;
		}
		
		return head;
	}
	
	
	
}
