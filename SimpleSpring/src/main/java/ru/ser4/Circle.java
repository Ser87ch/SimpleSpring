package ru.ser4;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;

	@Override
	public void draw() {
		System.out.println(messageSource.getMessage("circle", new Object[] {center.getX(), center.getY()}, "empty", null));
		publisher.publishEvent(new DrawEvent(this));
	}

	public void setPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
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

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;

	}
}
