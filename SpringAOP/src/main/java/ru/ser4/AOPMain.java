package ru.ser4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.ser4.service.ShapeService;

public class AOPMain {

	public static void main(String[] args) {
		try(AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml")) {
			ShapeService ss = ctx.getBean("ss", ShapeService.class);
			System.out.println(ss.getCircle().getName());
			System.out.println(ss.getTriangle().getName());
		}
	}

}
