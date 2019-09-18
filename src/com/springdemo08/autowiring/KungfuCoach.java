package com.springdemo08.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springdemo01.setup.Coach;
import com.springdemo01.setup.FortuneService;

@Component
public class KungfuCoach implements Coach {
	
	// 1 // Autowiring using default constructor
//	@Autowired
//	public KungfuCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	// 2 // Autowiring using setter method
	// it is not necessary to be a setter method but anything
	// you should expect it to initialize just after the constructor
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	// 3 // Autowiring using field injection (have a try without qualifier as well)
//	@Autowired
//	@Qualifier("random")
//	private FortuneService fortuneService;
	
	// 4 // @Qualifier is a nice feature, but it is tricky when used with Constructors.
	private FortuneService fortuneService;
	
	@Autowired
	public KungfuCoach(@Qualifier("fortuneServiceImpl") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "practice Kung-Fu for 2 hours per day";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
