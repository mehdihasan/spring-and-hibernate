package com.springdemo01.setup;

public class SimpleFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Search for your luck";
	}

}
