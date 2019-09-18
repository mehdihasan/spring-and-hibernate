package com.springdemo02.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo01.setup.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo02-BeanScope.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean isSame = (coach == alphaCoach);
		System.out.println("ARE THE SAME? :" + isSame);
		System.out.println("MEMORY LOCATION COACH: " + coach);
		System.out.println("MEMORY LOCATION ALPHA COACH: " + alphaCoach);
		
		context.close();
	}

}
