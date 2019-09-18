package com.springdemo01.setup;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextDemo01.xml");
		CricketCoach theCoach = context.getBean("cricketCoach", CricketCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmailaddress());
		System.out.println(theCoach.getTeam()); 
		context.close();
	}

}
