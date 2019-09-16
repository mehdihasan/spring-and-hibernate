package com.springdemo6.scopeandlifecyclewithannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.springdemo1.setup.Coach;

/**
 * @author mehdi
 * for testing Bean life-cycle for annotation
 * special note about bean life-cycle: 
 * https://www.udemy.com/spring-hibernate-tutorial/learn/lecture/9281424#overview
 */
@Component
public class HaduduCoach implements Coach {

	@PostConstruct
	private void setup() {
		System.out.println("Just after initialization - Ha Du du coach!");
	}
	
	@PreDestroy
	private void cleanUp() {
		System.out.println("run this for cleanup - ha du du!");
	}
	
	@Override
	public String getDailyWorkout() {
		return "practice ha du du for 3 hours.";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
