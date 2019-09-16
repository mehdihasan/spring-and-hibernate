package com.springdemo6.scopeandlifecyclewithannotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.springdemo1.setup.Coach;
/**
 * @author mehdi
 * For testing Bean scope by annotation
 */
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return null;
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
