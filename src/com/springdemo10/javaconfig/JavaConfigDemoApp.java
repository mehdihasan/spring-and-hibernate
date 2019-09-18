package com.springdemo10.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

/**
 * @author mehdi
 * 
 * @objective: Configure spring container using java code. (using @ComponentScan, by defining @Component(s) )
 * 
 * @steps:
 * 1. Create a java class and annotate as @Configuration (SportConfig.java)
 * 2. Add component scanning support: @ComponentScan (optional) (SportConfig.java)
 * 3. Read spring java configuration class (JavaConfigDemoApp.java)
 * 4. Retrieve bean from spring container (JavaConfigDemoApp.java)
 */
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
