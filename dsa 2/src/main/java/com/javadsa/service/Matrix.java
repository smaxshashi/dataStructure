package com.javadsa.service;

import java.util.List;

public class Matrix {
	
	
	public void searchInMatrix(int[][] matrix, int value, int length) {
		
		int i=0;
		int j= length-1;
		while(i<length && j>0) {
			
			if(matrix[i][j]==value) {
				System.out.println("Found ");
			}else {
				if(matrix[i][j]>value) {
					j--;
				}else {
					i++;
				}
			}	
		}
		System.out.println("Not Found");
	}
	
	
	public void isValidSudoku(int[][] matrix) {
		
		for(int i=0;i<matrix.length;i++) {
			
			
			for(int j=0;j<matrix.length;j++) {
				
				
				
				
			}
		}
		
	}
	


}
