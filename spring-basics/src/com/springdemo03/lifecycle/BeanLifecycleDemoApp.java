package com.springdemo03.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo01.setup.Coach;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo03-BeanLifecycle.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		
		context.close();
	}

}
