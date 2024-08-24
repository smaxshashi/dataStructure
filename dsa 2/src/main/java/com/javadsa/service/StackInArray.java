package com.javadsa.service;

public class StackInArray {
	
	private int[] arr;
	private int top;
	
	
	public void push(int data) {
		
		if(isFull()) {
			System.out.println("Stack is Full ");
			return;
		}
		
		top++;
		arr[top]=data;
		
	}
	
	
	public int size() {
		return top+1;
	}
	
	public boolean isFull() {
		if(arr.length==size()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean isEmpty() {
		if(arr[top]<0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is already Empty ");
			return 0;
		}else {
			int temp=arr[top];
			top--;
			return temp;
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack is already Empty ");
			return 0;
		}else {
			return arr[top];
		}
		
	}

}
