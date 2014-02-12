package ru.ser4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import ru.ser4.model.Circle;

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
	public void secondAdvice(JoinPoint jp)
	{
		Circle c = (Circle) jp.getTarget();
		System.out.println(c + " Another advice run" + jp);
	}
	
	@AfterReturning(pointcut = "args(name)", returning="str")
	public void stringArg(String name, String str) {
		System.out.println(str + " String Arg " + name);
	}
	
	@Around("allGetters()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) {
		Object r = null;
		try {
			System.out.println("before");
			r = pjp.proceed();
			System.out.println("after");
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		
		return r;
	}
	
}
