package ru.ser4.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(* get*(..))")
	public void allGetters() {}
	
	@Pointcut("within(ru.ser4.model.Circle)")
	public void circleMethods() {}

	@Before("allGetters() && circleMethods()")
	public void loggingAdvice()	{
		System.out.println("Advice run");
	}
	
	@Before("circleMethods()")
	public void secondAdvice()
	{
		System.out.println("Another advice run");
	}
}
