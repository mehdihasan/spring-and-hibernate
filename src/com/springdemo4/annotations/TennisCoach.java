package com.springdemo4.annotations;

import org.springframework.stereotype.Component;

import com.springdemo1.setup.Coach;

@Component("theTennisCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Play tennis for 2 hours";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
