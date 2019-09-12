package com.springdemo4.annotations;

import org.springframework.stereotype.Component;

import com.springdemo1.setup.Coach;

/**
 * example Coach class of DEFAULT BEAN ID
 * 
 * @author mehdi
 *
 */
@Component
public class KarateCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "practice Karate for 2 hours for every 2 days";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
