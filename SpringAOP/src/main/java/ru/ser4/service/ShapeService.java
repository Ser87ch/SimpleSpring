package ru.ser4.service;

import org.springframework.beans.factory.annotation.Autowired;

import ru.ser4.model.Circle;
import ru.ser4.model.Triangle;

public class ShapeService {
	@Autowired
	private Circle circle;
	@Autowired
	private Triangle triangle;
	
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
