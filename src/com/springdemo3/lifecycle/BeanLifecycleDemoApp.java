package com.springdemo3.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanLifecycle.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		
		context.close();
	}

}
