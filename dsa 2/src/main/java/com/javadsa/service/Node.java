package com.javadsa.service;

public class Node {
	
	int key;
	Node next;
	
	public Node(int key) {
		this.key = key;
		next = null;
	}

	@Override
	public String toString() {
		return  key + "--->" + next;
	}

}
