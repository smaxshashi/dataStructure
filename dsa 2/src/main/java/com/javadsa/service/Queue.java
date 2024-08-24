package com.javadsa.service;

import java.util.Arrays;
import java.util.LinkedList;

public class Queue {  ///FIFO

	private Node front;
	private Node rear;
	private int length;
	
	
	public Queue() {
		this.front=null;
		this.rear=null;
		this.length=0;
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
	
	
	public void enqueue(int key) {
		
		Node temp= new Node(key);
		if(isEmpty()) {
			front=temp;
		}else {
			rear=rear.next;
		}
		rear=temp;
		length++;
		//System.out.println(front);
		
	}
	
	
	public int dequeue() {
		if (isEmpty()) {
			return 0;
		} else {
			int result = front.key;
			front = front.next;
			if (front == null) {
				rear = null;
			}
			length--;
			return result;
		}
	}
	
	
	public void printQueue() {
		Node current=front;
		while(current!=null) {
			System.out.print(current);
			current= current.next;
		}
	}
	
	
	
	public String[] generateBinaryNumberByQueue(int num) { //FIFO
		String[] resultStrArr= new String[num];
		java.util.Queue<String> que= new LinkedList<>(); // From Java.util;
		que.offer("1");
		for(int i=0;i<num;i++) {
			resultStrArr[i]=que.poll();
			String n1=resultStrArr[i]+"0";
			String n2=resultStrArr[i]+"1";
			
			que.offer(n1);
			que.offer(n2);
		}
		System.out.println(Arrays.toString(resultStrArr));
		return resultStrArr;
	}
	
	

	public static void main(String[] args) {
		
		Queue que= new Queue();
		que.enqueue(10);
		que.enqueue(15);
		//que.enqueue(13);
		
		//que.printQueue();
		
		que.generateBinaryNumberByQueue(4);

	}

}
