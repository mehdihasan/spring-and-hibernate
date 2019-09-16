package com.springdemo6.scopeandlifecyclewithannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo6-ABSL.xml");
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		Coach betaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (alphaCoach == betaCoach);
		
		System.out.println("pointing to the same object: " + result);
		System.out.println("memory location for the coach: " + alphaCoach);
		System.out.println("memory location for beta coach: " + betaCoach);
		
		
		Coach haduduCoach = context.getBean("haduduCoach", Coach.class);
		System.out.println("coach instruction: " + haduduCoach.getDailyWorkout());
		
		context.close();
	}

}
