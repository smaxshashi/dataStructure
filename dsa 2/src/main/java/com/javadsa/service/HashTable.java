package com.javadsa.service;

public class HashTable {
	
	private HashNode[] buckets; //  array of type Hashnode
	private int numOfBucket;  // Capacity of array
	private int size;  //number of key value pair
	
	
	public HashTable(int capacity) {
		
		this.numOfBucket=capacity;
		this.buckets= new HashNode[numOfBucket];
		this.size=0;
		
	}
	
	//all of O(1)
	public int size() {
		return size;
	}
	
	
	
	public boolean isEmpty() {
		return size==0;
	}
	
	
	
	public void put(int key,String value) {
		int index= getBucketIndex(key);
		HashNode head= buckets[index];
		while(head!=null) {
			if(head.value.equals(value)) {
				head.value= value;
				return;
			}
			head=head.next;
	
		}
		size++;
		head=buckets[index];
		HashNode node= new HashNode(key,value); // new node at beginning
		node.next= head;
		buckets[index]=node;
	
	}
	
	
	
	private int getBucketIndex(int key) {
		return key % numOfBucket;
	}
	
	public String get(int key) {
		int index= getBucketIndex(key);
		HashNode head= buckets[index];
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
		}
		return null;
	}
	
	public String remove(int key) {
		return "";
		
	}
	
	
	
	

}
