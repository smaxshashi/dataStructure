package com.javadsa.service;

import java.util.Arrays;

public class DynamicProgramming {
	
	
	// Fibonnaci
	// Bottom down
	
	public int fibbonacci(int size) {
		int[] table= new int[size+1];
		//table[0]=0;
		table[1]=1;
		for(int i=2;i<=size;i++) {
			table[i]= table[i-1]+table[i-2];
		}
		return table[size];
	}
	
	
	
	// Optimization of recursion
	
	public int fibonacciByTopDown(int[] arr, int n) {
		
		//check array element solved and saved or not
		
		if(arr[n]==0) {
			
			if(n<2) {
				arr[n]=n;
				
			}else {
				int left = fibonacciByTopDown(arr, n-1);
				int right = fibonacciByTopDown(arr, n-2);
				arr[n]=left+right;
			}
			
		}
		return arr[n];
		
		
	}
	
	
	public void unboundedKnapSack(int [] weight, int[] value, int bagCap) {
		
		int[] dp= new int[bagCap+1];
		dp[0]=0;
		
		for(int i=1;i<=bagCap;i++) {
			
			int maxWgt=0;
			for(int j=0;j<weight.length;j++) {
				
				if(weight[j]<=i) {
					int remainIndx= i-weight[j];
					int remainVal=dp[remainIndx];
					remainVal=remainVal+value[j];
					
					if(maxWgt<remainVal) {
						maxWgt=remainVal;
					}
					
				}
			}
			dp[i]=maxWgt;
		}
		System.out.println(Arrays.toString(dp));
		
	}
	
	
	public void decodeNumInDp(String str) {
		
		int[] dp= new int[str.length()];
		dp[0]= 0;
		
		for(int i=1;i<str.length();i++) {
			
			if(str.charAt(i-1)=='0' && str.charAt(i)=='0') {
				dp[i]=0;
				
			}else if(str.charAt(i-1)=='0' && str.charAt(i)!='0') {
				dp[i]= dp[i-1];
				
			}else if(str.charAt(i-1)!='0' && str.charAt(i)=='0') {
				if(str.charAt(i-1) =='1' || str.charAt(i-1)=='2') {
					if(i>=2) {
						dp[i]=dp[i-2];
					}else {
						dp[i]=1;
					}
				
				}else {
					dp[i]=0;
				}
				
			}else {
				if(Integer.parseInt(str.substring(i-1,i+1))<=26) {
					if(i>=2) {
						dp[i]=dp[i-2]+dp[i-1];
					}else {
						dp[i]=dp[i-2]+1;
					}
				}else {
					dp[i]=dp[i-1];
				}
				
			}
			
		}
		
		
	}
	
	
	public void paintHouseRgb(int [][] arr) {
		
		int[][] dp= new int[arr.length][3];
		dp[0][0]= arr[0][0];
		dp[0][1]= arr[0][1];
		dp[0][2]= arr[0][2];
		
		for(int i=1;i<arr.length;i++) {
			
			dp[i][0]= arr[i][0]+ Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1]= arr[i][1]+ Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2]= arr[i][2]+ Math.min(dp[i-1][1], dp[i-1][0]);
		}
	}
	
	
	public void paintHouseManyColor(int[][] arr) {
		
		int[][] dp= new int[arr.length][arr[0].length];
		for(int i=0;i<arr[0].length;i++) {
			dp[0][i]= arr[0][i];
			
		}
		for(int i=1;i<arr.length;i++) {
			
			int min= Integer.MAX_VALUE;
			for(int j=0;j<arr[0].length;j++) {
				
				for(int k=0;k<dp[i].length;k++) {
					if(j!=k) {
						if(dp[i-1][k]<min) {
							min = dp[i-1][k];
						}
						
					}
				}
				
				dp[i][j]=arr[i][j]+min;
			}
			
		}// answer is last row min
		
		int min= Integer.MAX_VALUE;
		for(int i=0;i<dp[0].length;i++) {
			if(dp[arr.length][i]<min) {
				min= dp[arr.length][i];
			}
		}
		System.out.println(min);
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		DynamicProgramming dp= new DynamicProgramming();
		//System.out.println(dp.fibbonacci(6));
		
		dp.unboundedKnapSack(new int[] {2,5,1,3,4}, new int[] {15,14,10,45,30}, 7);
		
	}

}
