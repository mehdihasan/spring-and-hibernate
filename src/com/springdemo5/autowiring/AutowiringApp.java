package com.springdemo5.autowiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class AutowiringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo5-Autowiring.xml");
		Coach kungfuCoach = context.getBean("kungfuCoach", Coach.class);
		System.out.println(kungfuCoach.getDailyWorkout());
		System.out.println(kungfuCoach.getDailyFortune());
		context.close();
	}

}
