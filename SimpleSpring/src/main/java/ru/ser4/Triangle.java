package ru.ser4;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean, Shape {

	private String s;
	private String c;
	private Point p1,p2,p3;
	private List<Point> points;
	@SuppressWarnings("unused")
	private ApplicationContext context;
	private String beanName;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
		
		p1 = points.get(0);
		p2 = points.get(1);
		p3 = points.get(2);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	@Required
	@Resource(name="p3")
	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	@Autowired
	@Qualifier("p3t")
	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Triangle(String c) {
		this.c = c;
	}

	@Override
	public void draw() {
		System.out.printf("%s Triangle %s %d %d %d %d %d %d", c, s, p1.getX(), p1.getY(),
				p2.getX(), p2.getY(),
				p3.getX(), p3.getY());
	}

	public void setS(String s) {
		this.s = s;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
		
	}

	@Override
	public void setBeanName(String arg0) {
		this.beanName = arg0;
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init " + beanName);
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy " + beanName);
		
	}
	
	public void initMy()
	{
		System.out.println("InitMy " + beanName);
	}
	
	@PostConstruct
	public void initTr()
	{
		System.out.println("InitTr " + beanName);
	}
}
