package com.javadsa.service;

public class Interval implements Comparable<Interval>{
	
	public int start;
	public int end;
	
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}


	@Override
	public int compareTo(Interval o) {
		
		return this.start-o.start;
	}
	
	
	
	
	

}
