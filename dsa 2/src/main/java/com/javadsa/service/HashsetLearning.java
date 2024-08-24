package com.javadsa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashsetLearning {
	
	
	//unordered collection of objects in which duplicate values cannot be stored
	
	
	
	public static void operationOnSet() {
		
		
		List<Integer> firstInt= new ArrayList<>();
		firstInt.add(1);
		firstInt.add(5);
		firstInt.add(9);
		firstInt.add(12);
		
		
		List<Integer> secondInt= new ArrayList<>();
		secondInt.add(2);
		secondInt.add(3);
		secondInt.add(4);
		secondInt.add(11);
		
		List<Integer> addedList= new ArrayList<>();
		addedList.addAll(firstInt);
		addedList.addAll(secondInt);
		System.out.println("---> "+addedList);
		
		
		Set<Integer> stringSet= new HashSet<>();
		
		stringSet.addAll(firstInt);
		stringSet.addAll(secondInt);
		System.out.println("set ---> "+stringSet);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		operationOnSet();
		
	}

}
