package com.javadsa.service;

import java.util.ArrayList;
import java.util.List;

public class OverLappingIntervals {
	
	
	public List<Interval> overLapInterval(List<Interval> intervals){
		
		intervals.sort((o1, o2) -> o1.start-o2.start);
		
		List<Interval> result= new ArrayList<>();
		int start= intervals.get(0).start;
		int end= intervals.get(0).end;
		
		for(int i=1;i<intervals.size();i++) {
			
			Interval interval=intervals.get(i);
			if(interval.start<=end) {
				end=interval.end;
			}else {
				result.add(new Interval(start,end));
				start=interval.start;
				end= interval.end;
			}
			
		}
		result.add(new Interval(start,end));
		return result;
		
		
		
	}
	 
	

}
