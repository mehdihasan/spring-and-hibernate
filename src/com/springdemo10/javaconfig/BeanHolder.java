package com.springdemo10.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdemo1.setup.Coach;
import com.springdemo1.setup.FortuneService;
import com.springdemo1.setup.SimpleFortuneService;

@Configuration
public class BeanHolder {

	// objective: to learn inject Fortune service using just raw java code
	
	// 1. define method to expose bean
	// 2. inject bean dependencies
	
	@Bean
	public FortuneService fortuneService() {
		return new SimpleFortuneService();
	}
	
	@Bean
	public Coach hockeyCoach() {
		return new HockyCoach(fortuneService());
	}
	
	
	// 3. read spring java configuration class
	
	// 4. retrieve bean from Spring container
}
