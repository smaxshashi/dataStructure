package com.javadsa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HackerRank {
	
	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
	        Map<Integer, Integer> map = new HashMap<>();
	        List<Integer> stack = new ArrayList<>();
	        for(int i=0; i< t; i++) {
	            int x = sc.nextInt();
	            int n = sc.nextInt();
	            if(x == 1) {
	                // map to store integer and its frequency
	                map.put(n, map.getOrDefault(n, 0)+1);
	                stack.add(n);
	            } else {
	                // System.out.println("Map: " + map);
	                
	                int maxFreq = 0;
	                int maxElement = 0;
	                for(int k: stack) {
	                    if(map.get(k) > maxFreq) {
	                        maxElement = k;
	                        maxFreq = map.get(k);
	                    }
	                }
	                // could be multiple values with same frequency, so keep it in a stack and check
	                // from the end of the stack if any element is present in the stack
	                Set<Integer> set = new HashSet<>();
	                for(Map.Entry<Integer, Integer> e: map.entrySet()) {
	                    if(e.getValue() == maxFreq) {
	                        set.add(e.getKey());
	                    }
	                }
	                // after the above loop, set will contain all elements with frequency = maxFreq
	                // System.out.println("Need to remove one of " + set + " with maxFrequency " + maxFreq);
	                int indexToRemove = -1;
	                for(int j = stack.size()-1; j>=0; j--) {
	                    if(set.contains(stack.get(j))) {
	                        indexToRemove = j;
	                        break;
	                    }
	                }
	                int num = stack.remove(indexToRemove);
	                map.put(num, map.get(num) -1);
	                System.out.print(num + " ");
	            }
	        }
		
		
	}

}
