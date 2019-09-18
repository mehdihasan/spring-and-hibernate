package com.springdemo4.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo4-Annotations.xml");
		
		// using custom bean ID
		Coach coach = context.getBean("theTennisCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		
		// using default bean ID
		Coach karateCoach = context.getBean("karateCoach", Coach.class);
		System.out.println(karateCoach.getDailyWorkout());
		
		context.close();
	}

}
