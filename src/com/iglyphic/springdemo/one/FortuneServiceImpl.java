package com.iglyphic.springdemo.one;

import java.util.List;

public class FortuneServiceImpl implements FortuneService {

	private List<String> fortuneList;
	
	public FortuneServiceImpl(List<String> fortuneList) {
		this.fortuneList = fortuneList;
	}

	public String getFortune() {
		int index = (int) (Math.random() * 2 + 0);
		return fortuneList.get(index);
	}

}
