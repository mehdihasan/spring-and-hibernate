package com.springdemo10.javaconfig;

import com.springdemo1.setup.Coach;
import com.springdemo1.setup.FortuneService;

public class HockyCoach implements Coach {

	private final FortuneService fortuneService;
	
	public HockyCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "run for 1 hour + practice hockey for 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
