package ru.ser4.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle set");
	}
	
	public String setNameReturn(String name) {
		this.name = name;
		System.out.println("Circle set");
		return name;
	}
}
