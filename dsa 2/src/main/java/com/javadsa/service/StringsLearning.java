package com.javadsa.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class StringsLearning {

	public String[] splitString(String string) {
		String str[] = string.split(" ");
		return str;

	}

	public void printSplittedString(String[] str) {
		for (String s : str) {
			System.out.println(s);
		}
	}

	public static void reverseString() {
		String originalStr = " Hello world";
		String reverseStr = "";
		for (int i = 0; i < originalStr.length(); i++) {
			reverseStr = originalStr.charAt(i) + reverseStr;
		}
		System.out.println("Reverse String " + reverseStr);

	}

	public static void isPalindromeString(String word) {

		char[] wordChar = word.toCharArray();
		int start = 0;
		int end = word.length() - 1;
		while (start < end) {
			if (wordChar[start] != wordChar[end]) {
				System.out.println("Is not palindrome ");
				break;
			}
			start++;
			end--;

		}
		System.out.println("Yes ");

	}

	public static void reverseStringByStack(String str) {

		Stack<Character> charStack = new Stack<>();
		char[] charArray = str.toCharArray();

		for (char c : charArray) {
			charStack.push(c);
		}

		for (int i = 0; i < str.length(); i++) {
			charArray[i] = charStack.pop();
		}
		System.out.println(new String(charArray));

	}

	public Boolean isValidSubSequence(String stringGiven, String toCheckStr) {

		int i = 0;
		int j = 0;
		int count = 0;
		while (i < stringGiven.length() && j < toCheckStr.length()) {

			if (stringGiven.charAt(i) == toCheckStr.charAt(j)) {
				j++;
				count++;
			}
			i++;
		}
		if (count == toCheckStr.length()) {
			return true;
		}
		return false;

	}

	public int firstNonRepeating(String str) {

		Map<Character, Integer> map = new HashMap<>();
		char[] chr = str.toCharArray();

		for (char c : chr) {
			map.put(c, map.getOrDefault(c, 0) + 1);
			// System.out.println(map.toString());
		}

//    	 for(Map.Entry<Character, Integer> entry: map.entrySet()) { // not work as hashmap not ordered
//    		 if(entry.getValue()==1) {
//    			 System.out.println(entry.getKey());
//    			 return entry.getValue();
//    		 }
//    	 }
		for (int i = 0; i < chr.length; i++) {
			char ch = chr[i];
			if (map.get(ch) == 1) {
				System.out.println(chr[i]);
				return i;
			}
		}
		return -1;

	}

	public String removeVowel(String str) {

		Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
		char[] ch = str.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char c : ch) {
			if (!vowel.contains(c)) {
				sb.append(c);
			}
		}
		return sb.toString();

	}

	public int subStringLengthNonRepeating(String str) {

		int maxLength = 0;
		int left = 0;
		int right = 0;

		Set<Character> charSet = new HashSet<>();

		while (right < str.length()) {
			char c = str.charAt(right);

			if (charSet.add(c)) {
				maxLength = Math.max(maxLength, left - right + 1);
				right++;

			} else {

				while (str.charAt(left) != c) {
					charSet.remove(str.charAt(left));
					// maxLength= Math.max(maxLength, left-right+1);
					left++;
				}
				charSet.remove(c);
				left++;
			}

		}
		return maxLength;

	}

	public String removingKconsecutive(String str, int k) { // geeksforgeeks --> gksforgks

		Stack<Character> stack = new Stack<Character>();
		HashMap<Character, Integer> hashMap = new HashMap<>();

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}

		return str;

	}

	public void nextGreaterElement(int[] arr) {
		int[] nextGreaterArr = new int[arr.length];

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);

		for (int i = 1; i < arr.length; i++) {

			if (stack.size() > 0 && arr[i] > arr[stack.peek()]) {
				int prevIndx = stack.peek();
				nextGreaterArr[prevIndx] = arr[i];
			}
			stack.push(i);

		}
		while (stack.size() > 0) {
			int remainIdx = stack.peek();
			arr[remainIdx] = -1;
		}
		System.out.println(Arrays.toString(nextGreaterArr));

	}

	public void reverseWordInString(String words) {
		System.out.println(words);

		Stack<String> stack = new Stack<>();
		String temp = "";
		String ans = "";

		for (int i = 0; i < words.length(); i++) {
			char c = words.charAt(i);
			if (c == ' ') {
				if (temp.length() > 0) {
					stack.push(temp);
					temp = "";
				} else {
					temp = "";
				}
			} else {
				temp = temp + c;
			}
		}
		stack.push(temp);
		int count = 0;
		while (stack != null && count < stack.size()) {
			String output = stack.pop();
			System.out.print(ans + " " + output);

		}

	}

	public void longestCommonPrefix(String[] str) {

		System.out.println(Arrays.toString(str));
		Arrays.sort(str);
		System.out.println(Arrays.toString(str));

		StringBuilder prefix = new StringBuilder();

		String lowestString = str[0];

		for (int i = 0; i < lowestString.length(); i++) {

			Boolean match = true;

			for (int j = 1; j < str.length; j++) {

				if (str[j].charAt(i) != lowestString.charAt(i)) {
					match = false;
					break;
				}
			}
			if (match) {
				prefix.append(lowestString.charAt(i));
			}

		}
		System.out.println(prefix);

	}

	public void longestPrefixAndSuffix(String str) {

		String result = "";
		int mid = (0 + str.length()) / 2;
		int i = 0;
		int k = mid + 1;

		if (str.length() % 2 == 0) {
			mid = mid + 1;
			k = k - 1;
		}

		while (i < mid && k < str.length()) {
			if (str.charAt(i) == (str.charAt(k))) {
				result += str.charAt(i);
				k++;
				i++;
			}
		}
		System.out.println(result);
		System.out.println(result.length());

	}

	public void smallestSubStringWindow(String str1, String str2) {

		HashMap<Character, Integer> hashMap1 = new HashMap<>();
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			hashMap1.put(ch, hashMap1.getOrDefault(ch, 0) + 1);
		}
		HashMap<Character, Integer> hashMap2 = new HashMap<>();
		int matchCount = 0;
		int desiredMc = str1.length();

		// Acquire

		int i = -1;
		int j = -1;

		while (i < str1.length() - 1 && matchCount < desiredMc) {
			i++;
			char idxChar = str1.charAt(i);
			hashMap2.put(idxChar, hashMap2.getOrDefault(idxChar, 0) + 1);

			if (hashMap2.getOrDefault(idxChar, 0) <= hashMap1.getOrDefault(idxChar, 0)) {
				matchCount++;

			}

		}

		// Release

		while (j < i && matchCount == desiredMc) {

		}

	}

	public String reverseWords(String s) {

		String[] str = s.trim().split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = str.length - 1; i > 0; i--) {
			sb.append(str[i]);

		}
		return sb.toString();

	}

	public String alternateWords(String str1, String str2) {

		int i = 0;
		int j = 0;
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = true;
		while (i < str1.length() && j < str2.length()) {

			if (flag) {
				char c1 = str1.charAt(i);
				stringBuilder.append(c1);
				flag = false;
				i++;
			} else {
				char c2 = str2.charAt(j);
				stringBuilder.append(c2);
				flag = true;
				j++;
			}
		}
		while (i < str1.length()) {
			stringBuilder.append(str1.charAt(i));
			i++;
		}
		while (j < str2.length()) {
			stringBuilder.append(str2.charAt(j));
			j++;
		}

		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();

	}

	public int compress(char[] chars) {

		StringBuilder stringBuilder = new StringBuilder();
		int count = 1;
		stringBuilder.append(chars[0]);
		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == chars[i]) {
				count++;

			} else {
				stringBuilder.append(count);
				stringBuilder.append(chars[i]);
				count = 1;
			}
		}
		stringBuilder.append(count);
		System.out.println(stringBuilder);
		return stringBuilder.length();
		
		
	}
	
	public void isStringPalindrome(String str) {
		
		int i=0;
		int j=str.length()-1;
		
		while(i<j) {
			if(str.charAt(i)==str.charAt(j)) {
				i++;
				j--;
			}else {
				System.out.println("Not Palindrome");
				return;
			}
			
		}
		System.out.println("is Palindrome");
		
	}
	
	
	public void isStringSubsequence(String str1, String str2) {
		
		
		int i=0;
		int j=0;
		while(i <str2.length()-1 || j<str1.length()-1) {
			
			if(str2.charAt(i)==str1.charAt(j)) {
				i++;
				j++;
			}
			else {
				j++;
			}
			
	
		}if(i>str2.length()-1) {
			i=i-1;
		}
		if(str2.charAt(i)==str1.charAt(j-1)) {
			System.out.println("it has");
			return;
		}
		System.out.println("iNot");
		
	}
	
	public void isAnagram(String str1, String str2) {
		
		int[] arr= new int[256];
		
		int i=0;
		while(i<str1.length()) {
			arr[str1.charAt(i)]++;
			arr[str2.charAt(i)]--;
			i++;
		}
		for(int j=0;j<arr.length;j++) {
			if(arr[j]!=0) {
				System.out.println("Not Anagram");
				return;
			}
		}
		System.out.println("Anagram");
		
	}
	
	
	public void leftMostRepeatingCharacter(String str) {
		
		int[] arr=new int[256];
		for(int i=0;i<str.length();i++) {
			
			arr[str.charAt(i)]++;
			
		}
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]>1) {
				System.out.println(i);
				return;
				
			}
		}
		System.out.println("better luck next time");
		
		
		
	}
	
//	public void reverseWordInString(String str) {
//		
//		Stack<String> stack = new Stack();
//		for(int i)
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// isPalindromeString("madam");
		StringsLearning string = new StringsLearning();

		// reverseStringByStack("aman is fool");
		// System.out.println(string.isValidSubSequence("abcd","aec"));
		// char[] arr = { "geeksforgeeks", "geeks", "geek", "geezer" };
		// char[] charArray = {"a","a","b","b","c","c","c"};

		//string.compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' });
		
		string.leftMostRepeatingCharacter("cabbad");

	}

}
