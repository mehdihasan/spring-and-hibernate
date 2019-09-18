package com.springdemo10.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// using custom bean ID
		Coach coach = context.getBean("theTennisCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		
		// using default bean ID
		Coach karateCoach = context.getBean("karateCoach", Coach.class);
		System.out.println(karateCoach.getDailyWorkout());
		
		context.close();
	}

}
