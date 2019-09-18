package com.springdemo08.autowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo01.setup.Coach;

public class AutowiringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo08-Autowiring.xml");
		Coach kungfuCoach = context.getBean("kungfuCoach", Coach.class);
		System.out.println(kungfuCoach.getDailyWorkout());
		System.out.println(kungfuCoach.getDailyFortune());
		context.close();
	}

}
