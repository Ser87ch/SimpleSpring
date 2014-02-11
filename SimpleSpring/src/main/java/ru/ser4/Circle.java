package ru.ser4;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

	private Point center; 
	private MessageSource messageSource;

	@Override
	public void draw() {
		System.out.println(messageSource.getMessage("circle", new Object[] {center.getX(), center.getY()}, "empty", null));
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}

	@Resource
	public void setRbms(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
