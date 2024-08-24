package com.javadsa.service;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapLearning {
	
	public static void hashMapOpertaion() {
		HashMap<String, Integer> myhashMap= new HashMap<>();
		myhashMap.put("Shashi ", 26);
		myhashMap.put("Aman ", 26);
		myhashMap.put("Rishabh ", 26);
		myhashMap.put("Kittu ", 26);
		
		for(String x:myhashMap.keySet()){
		
			System.out.println("Name = "+ x+ " age = "+myhashMap.get(x));
		}
		
	}
	
	
	public void groupAnagram(ArrayList<String> string) {
		
		HashMap<HashMap<Character, Integer>, ArrayList<String>> hashMap= new HashMap<>();
		
		for(String str:string) {
			
			HashMap<Character, Integer> freq = new HashMap<>();
			for(int i=0;i<str.length();i++) {
				char c= str.charAt(i);
		
				freq.put(c,freq.getOrDefault(c, 0)+1);
			}
			if(hashMap.containsKey(freq)==false){
				ArrayList<String> strArr= new ArrayList<>();
				strArr.add(str);
				hashMap.put(freq, strArr);
				
			}else {
				ArrayList<String> getList=hashMap.get(freq);
				getList.add(str);
			}
			
		}
		
	}

}
