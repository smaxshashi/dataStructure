package com.javadsa.service;

public class Places {
	
	
	@Override
	public String toString() {
		return   name + "(" + distance+ ")" ;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	String name;
	Integer distance;

}
