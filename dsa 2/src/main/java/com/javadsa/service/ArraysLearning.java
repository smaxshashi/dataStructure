package com.javadsa.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArraysLearning {

	private String numStrings = "12,37,6,87,10";

	public int[] readInteger(String str) {
		String[] st = str.split(",");
		int[] myArray = new int[st.length];

		for (int i = 0; i < st.length; i++) {
			myArray[i] = Integer.parseInt(st[i].trim());
		}
		return myArray;

	}

	public void minimumNum(int[] intg) {
		Arrays.sort(intg);
		int max = intg[intg.length - 1];
		int min = intg[0];
		System.out.println("Minimum " + min);

	}

	public static void missingNumArrayByForLoop(int[] intArray, int tillNum) { // {1, 2, 4, 6, 3, 7, 8}, N = 8
		Arrays.sort(intArray);
		System.out.println("Array " + Arrays.toString(intArray));
		int i = 1;
		int j = 0;
		while (i <= tillNum) {
			while (j < intArray.length) {
				if (i == intArray[j]) {
					i++;
					j++;
					break;
				} else {
					System.out.println(i);
					i = 10;
					j = 10;

				}

			}

		}

	}

	public static void missingNumArrayBySum(int[] intArray, int tillNum) {
		Arrays.sort(intArray);
		int tillSum = tillNum * (tillNum + 1) / 2;
		System.out.println("sum " + tillSum);
		int loopSum = 0;
		for (int i = 0; i < intArray.length; i++) {
			loopSum = loopSum + intArray[i];
		}
		System.out.println("loopSum " + loopSum);
		int result = tillSum - loopSum;
		System.out.println("Missing Num " + result);

	}

	public static void mergeTwoSortedArray(int[] intArrayFirst, int[] intArraySecond) {

		System.out.println("First Array " + Arrays.toString(intArrayFirst));
		System.out.println("Second Array " + Arrays.toString(intArraySecond));

		int[] intArrayThird = new int[intArrayFirst.length + intArraySecond.length];

		//// { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < intArrayFirst.length && j < intArraySecond.length) {

			if (intArrayFirst[i] <= intArraySecond[j]) {
				intArrayThird[k] = intArrayFirst[i];
				i++;
				k++;
			} else {
				intArrayThird[k] = intArraySecond[j];
				k++;
				j++;
			}
		}

		while (i < intArrayFirst.length) {
			intArrayThird[k] = intArrayFirst[i];
			i++;
			k++;
		}
		while (j < intArraySecond.length) {
			intArrayThird[k] = intArraySecond[j];
			j++;
			k++;
		}

		System.out.println("Merged Array " + Arrays.toString(intArrayThird));

	}

	public static void maxCircularSum(int[] intArrayFirst) {
		int arrayLength = intArrayFirst.length;

		int y = 0;
		for (int i = 0; i < arrayLength; i++) {
			y = y + intArrayFirst[i];
			intArrayFirst[i] = -1 * intArrayFirst[i];

		}
	}

	private static int kadanesSum(int[] intArrayFirst) {

		int sum = intArrayFirst[0];
		int tempSum = intArrayFirst[0];

		for (int i = 1; i < intArrayFirst.length; i++) {
			sum = sum + intArrayFirst[i];
			if (sum < intArrayFirst[i]) {
				sum = intArrayFirst[i];
				tempSum = Math.max(tempSum, sum);
			}
		}
		return tempSum;

	}

	public static void tripletSum(int[] intArrayFirst, int closeto) {
		int arrayLength = intArrayFirst.length;
		int closestSum = Integer.MAX_VALUE;

		for (int i = 0; i < arrayLength; i++) {

			for (int j = i + 1; j < arrayLength; j++) {

				for (int k = j + 1; k < arrayLength; k++) {

					int tripletSum = intArrayFirst[i] + intArrayFirst[j] + intArrayFirst[k];
					if (Math.abs(closeto - tripletSum) < closestSum) {
						closestSum = Math.abs(closeto - tripletSum);

					}
				}
			}
		}

	}

	public static void pascalTriangle(int n) {

		int[][] pascalTriangle = new int[n][n];

		for (int line = 0; line < n; line++) {

			for (int i = 0; i <= line; i++) {

				if (line == i || i == 0) {
					pascalTriangle[line][i] = 1;
				} else {
					pascalTriangle[line][i] = pascalTriangle[line - 1][i - 1] + pascalTriangle[line - 1][i];
					System.out.print(pascalTriangle[line][i]);
				}
				System.out.println("");

			}

		}

	}

	public static void trappingWater(int[] arr) { /// 3, 0, 2, 0, 4} 0 + 3 + 1 + 3 + 0 = 7

		int sum = 0;

		for (int i = 1; i < arr.length - 1; i++) {

			int left = arr[i];
			int right = arr[i];

			for (int j = 0; j < i; j++) {

				left = Math.max(left, arr[j]);

			}

			for (int k = i + 1; k < arr.length; k++) {

				right = Math.max(right, arr[k]);

			}

			sum = sum + Math.min(left, right) - arr[i];

		}
		System.out.println("Maximum water " + sum);

	}
	
	
	public void trappingWaterEfficient(int [] arr) {
		
		int result=0;
		
		int[] leftmax= new int[arr.length];
		int[] rightmax= new int[arr.length];
		
		leftmax[0]=arr[0];
		rightmax[arr.length-1]=arr.length-1;
		
		for(int j=1;j<arr.length;j++) {
			
			leftmax[j]=Math.max(leftmax[j-1], arr[j]);
			
		}
		
		for(int j=arr.length-2;j>=0;j--) {
			
			rightmax[j]=Math.max(rightmax[j+1], arr[j]);
			
		}
		
		
		for(int i=1;i<arr.length-2;i++) {
			
			result= result+Math.min(leftmax[i],rightmax[i])- arr[i];
			
			System.out.println(result);
			
		}
		

		
	}

	public static void findInSortedArray(int[] intArray, int num) { /// {1, 3, 5, 6} K = 2

		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i] == num) {
				System.out.println("Found It at Index " + i);
			} else if (intArray[i] > num) {
				System.out.println("Placed at Index " + i);
				break;
			}
		}

	}

	public static void minimumInArray(int[] array) {

		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}

	}

	public int searchByBinarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (key < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	// Kadanes

	public int maxSubArraySum(int[] arr) {

		int maxSoFar = arr[0];
		int currentMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			currentMax = currentMax + arr[i];
			if (currentMax < arr[i]) {
				currentMax = arr[i];
				// currentMax=Math.max(currentMax+arr[i], arr[i]);
			}
			if (maxSoFar < currentMax) {
				maxSoFar = currentMax;
			}
		}
		return maxSoFar;

	}

	// Check Duplicate in Array

	public boolean ifArrayContainDupli(int[] arr) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (hashSet.contains(arr[i])) {
				return true;
			}
			hashSet.add(arr[i]);
		}
		return false;
	}

	// Two sum to Target Index (a+b=target a,b ka index) ***************

	public int[] twoSumTarget(int[] arr, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (!map.containsKey(target - arr[i])) {
				map.put(arr[i], i);
			} else {
				result[1] = i;
				result[0] = map.get(target - arr[i]);
				return result;
			}
		}
		return result;

	}

	// Reverse the Number

	public int reverseDigit(int num) {

		StringBuilder str = new StringBuilder();
		int remainingNum = num;
		while (remainingNum > 0) {
			int lastDigit = remainingNum % 10;
			str.append(lastDigit);
			remainingNum = remainingNum / 10;
		}
		return Integer.valueOf(str.toString());

	}

	public int[] removeElement(int[] arr, int num) { // Do check

		int i = 0;
		int j = arr.length - 1;
		while (i < arr.length && j >= 0 && i <= j) {
			int x = arr[i] - num;
			int y = arr[j] - num;
			if (x == 0) {
				int temp = arr[j];
				arr[j] = x;
				arr[i] = temp;
				j--;
			}
			if (y == 0) {
				i++;
			}

		}
		return arr;
	}

	public int[] removeDuplicateInSorted(int[] arr) {

		int i = 1;
		int j = 1;
		while (j < arr.length) {
			if (arr[j] == arr[j - 1]) {
				j++;
			} else {
				arr[i] = arr[j];
				i++;
				j++;
			}
		}
		return arr;
	}

	public void tripletSumOfArray(int[] arr, int target) {

		Arrays.sort(arr);

		int i = 0;
		int k = arr.length - 1;
		while (i < arr.length) {
			int j = i + 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == target) {
					System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					j++;
					k--;
				}
				if (sum > target) {
					k--;
				}
				if (sum < target) {
					j++;
				}
			}
			i++;

		}

	}

	public int[] productsExclIndex(int[] arr) {
		int temp = 1;
		int[] resultArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			resultArr[i] = temp;
			temp = temp * arr[i];
		}
		temp = 1;
		for (int j = arr.length - 1; j >= 0; j--) {
			resultArr[j] = resultArr[j] * temp;
			temp = temp * arr[j];
		}
		return resultArr;
	}

	public int[] slidingWindow(int[] arr) {

		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length - 2; i++) {
			int maxOfTwo = Math.max(arr[i], arr[i + 1]);
			int max = Math.max(maxOfTwo, arr[i + 2]);
			result[i] = max;
		}
		return result;

	}

	public void slidingWindowMaxSum(int[] arr) {

		int result = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int sum = arr[i] + arr[i + 1] + arr[i + 2];
			if (sum > result) {
				result = sum;
			}
		}
		System.out.println(result);

	}

	public void squareOfArray(int[] arr) {
		System.out.println("Input " + Arrays.toString(arr));
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (Math.abs(arr[i]) < Math.abs(arr[j])) {
				arr[j] = arr[j] * arr[j];
				j--;
			} else {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				arr[j] = arr[j] * arr[j];
				j--;
			}
		}
		System.out.println("Outputed " + Arrays.toString(arr));

	}

	public void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			int temp = arr[i];
			int j = i - 1;
			while (j >= 0) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
					arr[j] = temp;
					j--;
				} else {
					break;
				}
			}

		}
		System.out.println(Arrays.toString(arr));
	}

	public void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}

	}

	public static void tripletSumByLoop(int[] arr, int target) {

		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < arr.length - 2; i++) {

			for (int j = i + 1; j < arr.length - 1; j++) {

				for (int k = j + 1; k < arr.length; k++) {

					int sum = arr[i] + arr[j] + arr[k];

					if (sum == target) {
						System.out.println("Found " + arr[i] + ", " + arr[j] + ", " + arr[k]);
						break;
					}
				}
			}

		}
	}

	public static void subArrayHavingSum(int[] arr, int target) {

		int ans = 0;
		int sum = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		hashMap.put(0, 1);

		for (int i = 0; i < arr.length; i++) {

			sum = sum + arr[i];
			int remSum = sum - target;
			if (hashMap.containsKey(remSum)) {
				ans = ans + hashMap.get(remSum);
			}
			hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);

		}
		System.out.println(ans);

	}
	
	

	public static void kMostFreqArrayElement(int[] arr, int k) {

		HashMap<Integer, Integer> freqHashMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			freqHashMap.put(x, freqHashMap.getOrDefault(x, 0) + 1);
		}

		List<Integer>[] bucketList = new ArrayList[arr.length + 1];

		// int[] bucketList= new int[arr.length+1];

		for (int key : freqHashMap.keySet()) {

			int freq = freqHashMap.get(key);

			if (bucketList[freq] == null) {
				bucketList[freq] = new ArrayList<>();

			}
			bucketList[freq].add(key);
		}

		int[] answer = new int[k];
		int count = 0;
		for (int i = bucketList.length - 1; i > 0; i--) {

			if (bucketList[i] != null) {

				for (int j = 0; j < bucketList[i].size(); j++) {
					int bl = bucketList[i].get(j);
					if (bl != 0) {
						answer[count++] = bl;
					}
				}

			}

		}

	}
	
	public static void maxProfitStock(int[] arr) {
		
		int leastSoFar=Integer.MAX_VALUE;
		int overallProfit=0;
		int todayProfit=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<leastSoFar) {
				leastSoFar= arr[i];
			}
			todayProfit=arr[i]-leastSoFar;
			if(overallProfit<todayProfit) {
				overallProfit= todayProfit;
			}
		}
		System.out.println(overallProfit);
		
	}
	
	
	public static void thirdMaxInArray(int[] arr) {
		
		int max=Math.max(arr[0], arr[1]);
		int secondMax=Math.min(arr[0], arr[1]);
		int thirdMax= Integer.MIN_VALUE;
		
		for(int i=2;i<arr.length;i++) {
			
			if(thirdMax<arr[i]) {
				thirdMax= arr[i];
				
			}
			if(secondMax<arr[i]) {
				thirdMax=secondMax;
				secondMax=arr[i];

			}
			if(max<arr[i]) {
				secondMax=max;
				max=arr[i];
				
			
			}
		}
	}
	
	public void moveZeroes(int[] nums) {
		
		int i=0;
		int j=1;
		
		while (j < nums.length) {
			if (nums[i] == 0) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			} else if (nums[j] == 0) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}

		}
		
	}
	
	public boolean isArrayAscending(int[] nums) {
		boolean flag=false;
		int min=nums[0];
		int index= 0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<min) {
				min= nums[i];
				index=i;
			}
		}
		if(index>=nums.length-2) {
			System.out.println(false);
			return false;
		}
		int secondMin=nums[index+1];
		int secondIndex=index+1;
		for(int i=secondIndex;i<nums.length;i++) {
			if(nums[i]<secondMin) {
				secondMin=nums[i];
				secondIndex=i;
				
			}
		}
		if(min<secondMin) {
			flag= true;
		}
		if(index>=nums.length-1) {
			System.out.println(false);
			return false;
		}
		int thirdMin=nums[secondIndex+1];
		int thirdIndex=secondIndex+1;
		for(int i=thirdIndex;i<nums.length;i++) {
			if(nums[i]<thirdMin) {
				thirdMin=nums[i];
				thirdIndex=i;
				
			}
		}
		if(secondMin<thirdMin) {
			flag= true;
		}
		System.out.println(min+" "+secondMin+" "+thirdMin);
		System.out.println(index+" "+secondIndex+" "+thirdIndex);
		System.out.println(flag);
		return flag;
		
	}
	
	public void insertIntoArray(int[] arr, int pos, int value) {
		System.out.println(" Inputed array "+Arrays.toString(arr));
		
		
		int arrSize = arr.length;
		if(arr[arrSize-1]!=0) {
			System.out.println("Array is full ");
		}
		
		for(int i=arrSize-1;i>=pos-1;i--) {
			arr[i]= arr[i-1];
			
		}
		arr[pos-1]=value;
		
		System.out.println(" Outputed array "+Arrays.toString(arr));

		
	}
	
	public void secondLargestInArray(int[] arr) {
		
		System.out.println(Arrays.toString(arr));
		int firstLargest=arr[0];
		int secondLargest=0;
		
		for(int i=1;i<arr.length;i++) {
			
			if(firstLargest<arr[i]) {
				secondLargest= firstLargest;
				firstLargest=arr[i];
				
			}
		}
		System.out.println(secondLargest);
		
	}
	
	public boolean isArraySorted(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]<=arr[i+1]) {
				return true;
			}else {
				return false;
			}
			
		}
		return false;
		
	}
	
	public void reverseArray(int[] arr) {
		
		System.out.println(Arrays.toString(arr));
		
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			int temp= arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
		System.out.println("reversed"+Arrays.toString(arr));
		
	}
	
	public void removeDuplicate(int[] arr) {
		int i=0;
		int j=1;
		
		while(j<arr.length-2 || i<arr.length-2) {
			
			if(arr[i]!=arr[j]) {
				i++;
				j++;
			}else {
				i++;
				j++;
				arr[i]=arr[j];
			}

			
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	
	public void moveZeroesToEnd(int[] arr) {
		
		int count=0;
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]!=0) {
				
				int temp= arr[i];
				arr[i]= arr[count];
				arr[count]= temp;
				count++;
				
			}	
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	public void rotateArrayByD(int[] arr, int d) {
		//System.out.println(Arrays.toString(arr));
		reverseArray(arr,0,d-1);
		reverseArray(arr,d,arr.length-1);
		reverseArray(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	
	}
	
	private void reverseArray(int[] arr, int low, int high) {
		
		while(low<high) {
			swap(arr[low],arr[high]);
			low++;
			high--;
		}
		System.out.println(Arrays.toString(arr));

	}
	private void swap(int num1, int num2) {
		
		int temp = num1;
		num1= num2;
		num2= temp;
		
	}
	
	
	public void leaderInArray(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			boolean flag= true;
			
			int max=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				
				if(max<arr[j]) {
					max=arr[j];
					flag=false;
					
				}
				
			}if(flag) {
				System.out.print(max +" ");
			}
		}
		
	}
	
	public void leaderInArrayEfficient(int [] arr) {
		
		int currentLead=arr[arr.length-1];
		System.out.print(currentLead+" ");
		for(int i=arr.length-2;i>=0;i--) {
			
			if(arr[i]>currentLead) {
				currentLead=arr[i];
				System.out.print(currentLead+" ");
			}

		}
		
	}
	
	public void maximumDifferenceInArray(int[] arr) {
	
		int answer=0;
		for(int i=0;i<arr.length-1;i++) {
			int result=Integer.MIN_VALUE;
			for(int j=i+1;j<arr.length;j++) {
				
				int diff=arr[j]-arr[i];
				
				if(diff >result) {
					result= diff;
	
				}
				answer=Math.max(answer, result);
				
			}
			System.out.println(result);
			
		}
		System.out.println(answer);
		
	}
	
	public void frequencyOfNum(int[] arr) {
		
		int i=0;
		int j=1;
		int count=1;
		while(j<arr.length) {
			if(arr[i]==arr[j]) {
				count++;
			}else {
				System.out.println(arr[i]+" has "+count);
				i=j;
				count=1;
			}
			j++;

		}
		System.out.println(arr[i]+" has "+count);

	}
	
	
	public void maximumConseq1sInArray(int[] arr) {
		
		int j=0;
		int result=0;
		int count=0;
		
		while(j<arr.length) {
			
			if(arr[j]==1) {
				count++;
			}else {
				result=Math.max(result, count);
				count=0;
			}
			j++;
			
		}
		result=Math.max(result, count);
		System.out.println(result);
		
		
	}
	
	
	public void maximumSubArrayUsingLoop(int[] arr) {
		
		int result=0;
		for(int i=0;i<arr.length;i++) {	
			int current=arr[i];
			for(int j=i+1;j<arr.length;j++) {
				current=current+arr[j];
				result= Math.max(current, result);	
			}
		}
		System.out.println(result);

	}
	
	public void maximumSubArrayEfficient(int[] arr) {
		
		int overallMax= arr[0];
		int maxTill= arr[0];
		for(int i=1;i<arr.length;i++) {
			maxTill= Math.max(arr[i]+maxTill, arr[i]);
			overallMax=Math.max(maxTill, overallMax);
		}
		
		System.out.println(overallMax);
		
	}
	
	public void maximumEvenOddSubArray(int[] arr) {
		
		int count=1;
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]%2==0 && arr[i-1]%2==0) {
				count=1;
			}
			if(arr[i]%2!=0 && arr[i-1]%2==0) {
				count++;
			}
			if(arr[i]%2==0 && arr[i-1]%2!=0) {
				count++;
			}
			
		}
		System.out.println(count);
		
		
	}
	
	
	public void maxAppearingElem(int[] arrA, int[] arrB) {
		
		int[] freqArray= new int[100];
		for(int i=0;i<arrA.length;i++) {
			
			for(int j=arrA[i];j<=arrB[i];j++) {
				freqArray[j]=freqArray[j]+1;
			}
		}
		int maxCount=0;
		int whichNum=0;
		for(int i=0;i<freqArray.length;i++) {
			if(freqArray[i]>maxCount) {
				maxCount=freqArray[i];
				whichNum=i;
			}
		}
		System.out.println(whichNum+" is Maximum Appearing "+maxCount);
		
	}
	
	public void equilibriumPointInArray(int[] arr) {
		

		for(int i=0;i<arr.length;i++) {
			int leftSum=0;
			int Rightsum=0;
			for(int j=0;j<i;j++) {
				leftSum=leftSum+arr[j];
			}
			for(int j=i+1;j<arr.length;j++) {
				Rightsum=Rightsum+arr[j];
				
			}
			if(leftSum==Rightsum) {
				System.out.println("Equilibrium point "+arr[i]);
			}
			
		}
		System.out.println("No Equilibrium point ");
		
	}
	
	
	public void maximumElement(int[] arr) {
		
		int length=arr.length;
		int totalCountToBe=length/2;
		int maxCount=-1;
		
		for(int i=0;i<length;i++) {
			int count=0;
			for(int j=0;j<length;j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
				maxCount=Math.max(maxCount, count);
				
			}
			
		}
		if(maxCount>totalCountToBe) {
			System.out.println(maxCount);	
		}else {
			System.out.println(-1);	
		}
		
		
	}
	
	
	public void majorityElementByMooresVotingAlgo(int[] arr) {
		
		int result=0;
		int count=1;
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[result]==arr[i]) {
				count++;
			}else {
				count=0;
				result=i;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[result]==arr[i]) {
				count++;
			}
		}
		if(count<arr.length/2) {
			count=-1;
		}
		System.out.println(count);
		
	}
	
	
	public void subArrayWithGivenSum(int[] arr, int givenSum) {
		
		int i=0;
		int j=1;
		int sumToCheck=arr[0];
		while(j<arr.length-2 || i<arr.length-2) {
			if(sumToCheck==givenSum) {
				System.out.println("It's Present "+sumToCheck);
				return;
				
			}
			
			else if(sumToCheck>givenSum) {
				sumToCheck=sumToCheck-arr[i];
				i++;
				
			}else if(sumToCheck<givenSum) {
				sumToCheck+= arr[j];
				j++;
				
			}
			else {
				System.out.println("Not Present ");
			}
			
		}
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		ArraysLearning arr = new ArraysLearning();
		// missingNumArrayBySum(new int[] {1, 2, 3, 5},5);
		// missingNumArrayByForLoop(new int[] {1, 2, 4, 6, 3, 7, 8},8);
		// pascalTriangle(5);
		// mergeTwoSortedArray(new int[] {1, 3, 4, 5},new int[] {2, 4, 6, 8});

		// findInSortedArray(new int[] {1, 3, 5, 6},4);

		// trappingWater(new int[] {3, 0, 2, 0, 4});
		
		// System.out.println(arr.reverseDigit(1234));
		// int[] result =arr.removeElement(new int[] {3,2,2,3},3);
		// System.out.println(Arrays.toString(result));

		// int[] result =arr.removeDuplicateInSorted(new int[] {0,0,1,1,1,2,2,3,3,4});
		// System.out.println(Arrays.toString(result));

		// int[] result=arr.slidingWindow(new int[] {44,77,33,44,88,11});
		// System.out.println(Arrays.toString(result));

		// arr.slidingWindowMaxSum(new int[] {2,7,3,5,8,1});
		// arr.insertionSort(new int[] {4,1,2,3,5});

		//maxProfitStock(new int[] { 100, 180, 260, 310, 40, 535, 695});
		//arr.isArrayAscending(new int[] {20,100,10,12,5,13});
		
		//arr.secondLargestInArray(new int[] {20,100,10,12,5,13});
		//boolean res=arr.isArraySorted(new int[] {100,150,200});
		//System.out.println(res);
		
		arr.subArrayWithGivenSum(new int[] {1,4,20,3,10,5},33);
	}

}
