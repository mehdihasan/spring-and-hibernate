package com.iglyphic.springdemo.one;

public class BaseBallCoach implements Coach {

	private FortuneService fortuneService;
	
	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	private void init() {
		System.out.println("Bean is initing");
	}
	
	private void cleanUp() {
		System.out.println("Clean up my stuffs");
	}
}