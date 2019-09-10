package com.iglyphic.springdemo.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iglyphic.springdemo.one.Coach;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextBeanLifecycle.xml");
		
		Coach coach = context.getBean("myCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		
		context.close();
	}

}
