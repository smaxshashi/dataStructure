package com.javadsa.service;

public class HashNode {
	
	Integer key;   // key
	String value;  // value
	HashNode next; // Reference to next hashnode
	
	public HashNode(Integer key,String value) {
		this.key=key;
		this.value= value;
		next = null;
	}
	

}
