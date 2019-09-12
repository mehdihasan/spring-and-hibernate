package com.springdemo2.beanscope;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanScope.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean isSame = (coach == alphaCoach);
		System.out.println("ARE THE SAME? :" + isSame);
		System.out.println("MEMORY LOCATION COACH: " + coach);
		System.out.println("MEMORY LOCATION ALPHA COACH: " + alphaCoach);
		
		context.close();
	}

}
