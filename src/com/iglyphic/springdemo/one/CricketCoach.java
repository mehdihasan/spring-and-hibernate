package com.iglyphic.springdemo.one;

public class CricketCoach implements Coach {
	
	private String emailaddress;
	private String team;
	private FortuneService fortuneService;
	
	public CricketCoach() {
		System.out.println("Cricketcoach: inside no-arg constructor");
	}
	
	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() { 
		return "Bowling for 2 hour + bating for 2 hour.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
