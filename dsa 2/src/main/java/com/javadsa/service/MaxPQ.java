package com.javadsa.service;

public class MaxPQ {
	
	private Integer[] pqArray;
	private int size;
	
	public MaxPQ(int capacity) {
		pqArray= new Integer[capacity+1];
		size=0;
	}
	
	
	public int getSize() {
		return size;
	}
	
	
	public boolean isEmpty() {
		return size==0;
	}
	
	
	
	public void insert(int num) {
		if(getSize()<pqArray.length){
			size++;
			pqArray[size]=num;
			swim(size);
		}
	}
	
	public void swim(int k) {
		while(k>1 && pqArray[k/2]<pqArray[k]) {
			int temp= pqArray[k];
			pqArray[k]=pqArray[k/2];
			pqArray[k/2]=temp;
			k=k/2;
		}
	}
	
	
	public static void main(String[] args) {
		
		MaxPQ maxpq= new MaxPQ(7);
		
	}

}
