package com.elevysi.essentials;

public class Person implements PersonInterface{
	
	private String name;
	
	public void beCool(){
		System.out.println(String.format("%s is a cool person", this.name));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Person is %s", this.name);
	}
	
	
}
