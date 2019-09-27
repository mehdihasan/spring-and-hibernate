package com.springdemo.aop.around.v1;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

	private static Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the traffic fortune
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		// 
		logger.info("\n\nMain Program: Aroud Demo App");
		logger.info("--------");
		logger.info("My fortune is: " + trafficFortuneService.getFortune());
		logger.info("\n\n");
		logger.info("\n--Finished--");
		
		// close the context
		context.close();
	}

}
