package com.javadsa.service;

public class PracticeCoding {
	
	
	
	
	private static int recursionPract(int n) {
		
		if(n==1|| n==0) {
			return 1;
		}else {
			return n*recursionPract(n-1);
		}
	}
	
	
	private static int recursiveAdd(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return (1+recursiveAdd(a, b-1));
		}
	}
	
	private static int fibonacciSeries(int n) {
		if(n==1|| n==0) {
			return n;
		}else {
			return fibonacciSeries(n-1)+fibonacciSeries(n-2);
		}
	}
	
	
	public static void main(String[] args) {
		
		//System.out.println("Value of Fcatorial "+recursionPract(5));
		System.out.println("Value of fibonacciSeries "+fibonacciSeries(17));
		System.out.println(recursiveAdd(3,5));
	}

}
