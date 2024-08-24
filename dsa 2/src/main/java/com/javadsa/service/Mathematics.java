package com.javadsa.service;

public class Mathematics {
	
	
	public boolean isPrimeNumber(int num) {
		
		if(num==1) {
			return false;
		}if(num==2|| num==3) {
			return true;
		}
		if(num%2==0 || num%3==0) {
			return false;
		}
		for(int i=5;i*i<=num;i=i+6) {
			
			if(num%i==0||num%(i+2)==0) {
				return false;
			}
			
		}
		return true;
		
	}
	
	
	public void printDivisiorInAscending(int num) {

		int i;
		for (i = 1; i * i < num; i++) {
			if (num % i == 0) {
				System.out.println(i);
				
			}
		}
		for (; i >= 1; i--) {
			if (num % i == 0) {
				System.out.println(num / i);
			}
		}

	}
	
	public void primeFactorization(int num) {
		
		for(int i=2;i<num;i++) {
			
			while(num%i==0) {
				System.out.println(i);
				num=num/i;
			}
		}
		if(num!=1) {
			System.out.println(num);
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Mathematics mathematics= new Mathematics();
		
		//System.out.println(mathematics.isPrimeNumber(121));
		mathematics.primeFactorization(15);
		
	}

}
