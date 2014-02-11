package ru.ser4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");)
		{
			Shape tr = context.getBean("circle", Shape.class);
			System.out.println(context.getMessage("greeting", null, "empty", null));
			tr.draw();
			
		}

	}

}
