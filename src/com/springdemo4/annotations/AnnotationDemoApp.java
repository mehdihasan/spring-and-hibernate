package com.springdemo4.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");
		Coach coach = context.getBean("theTennisCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		context.close();
	}

}
