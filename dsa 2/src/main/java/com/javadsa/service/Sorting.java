package com.javadsa.service;

public class Sorting {
	
	
	public void bubbleSort(int[] arr) {
		
		boolean isSwapped;
		for(int i=0;i<arr.length-1;i++) {
			isSwapped= false;
			
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]= temp;
					isSwapped=true;
				}
			}
			
			if(!isSwapped) {
				break;
			}
		}
	}
		
	
	
	public void mergeSort(int[] arr, int[] temp, int low, int high) { // divide and conquer
		
		if(low<high) {
			int mid= low+ (high-low)/2;  //garbage collector if otherwise
			mergeSort(arr,temp,low,mid);
			mergeSort(arr,temp,mid+1,high);
			//mergeTwoSorted();
		}
		
	
		
	}
	
	public void mergeTwoSorted(int[] arr, int[] temp, int low,int mid, int high) {
		
		for(int i=low;i<=high;i++) {
			temp[i]= arr[i];
		}
		int i=low;
		int j= mid+1;
		int k=high;
		
		while(i<k) {
			
		}
		
	}
	

}
