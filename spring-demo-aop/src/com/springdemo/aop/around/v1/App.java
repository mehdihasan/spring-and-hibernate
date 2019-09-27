package com.springdemo.aop.around.v1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the traffic fortune
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		// 
		System.out.println("\n\nMain Program: Aroud Demo App");
		System.out.println("--------");
		System.out.println(trafficFortuneService.getFortune());
		System.out.println("\n\n");
		
		// close the context
		context.close();
	}

}
