package com.springdemo10.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo1.setup.Coach;

public class HockeyJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanHolder.class);
		
		Coach hockeyCoach = context.getBean("hockeyCoach", Coach.class);
		System.out.println(hockeyCoach.getDailyFortune());
		System.out.println(hockeyCoach.getDailyWorkout());
		
		context.close();
	}

}
