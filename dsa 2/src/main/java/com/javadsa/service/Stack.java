package com.javadsa.service;

import java.util.EmptyStackException;

public class Stack {
	
	private Node top;
	private int length;
	
	
	public Stack() {
		top=null;
		length=0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		if(length==0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void push(int data) {
		Node temp= new Node(data);
		temp.next=top;
		top= temp;
		length++;
		
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException(); 
		}else {
			int result=top.key;
			top=top.next;
			length--;
			return result;
		}
	}

	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return top.key;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Stack stack= new Stack();
		stack.push(5);
		stack.push(19);
		stack.push(10);
		stack.push(20);
		
		System.out.println(stack.peek());
			
		System.out.println(stack.pop());	
		System.out.println(stack.peek());
		
		
	}

}
