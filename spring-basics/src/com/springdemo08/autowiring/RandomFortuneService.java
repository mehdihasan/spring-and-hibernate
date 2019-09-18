package com.springdemo08.autowiring;

import org.springframework.stereotype.Component;

import com.springdemo01.setup.FortuneService;

@Component("random")
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You are going to experience random luck today";
	}

}
