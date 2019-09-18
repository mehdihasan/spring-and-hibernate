package com.springdemo10.javaconfig;

import org.springframework.beans.factory.annotation.Value;

import com.springdemo1.setup.Coach;
import com.springdemo1.setup.FortuneService;

public class HockyCoach implements Coach {
	
	@Value(value = "${foo.email}")
	private String email;
	
	@Value(value = "${foo.team}")
	private String team;
	

	private final FortuneService fortuneService;
	
	public HockyCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Hey " + team + ", run for 1 hour + practice hockey for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() + ", by " + email;
	}

}
