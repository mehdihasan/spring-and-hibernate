package com.springdemo08.autowiring;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.springdemo01.setup.FortuneService;

/**
 * TODO: How to inject properties file using Java annotations
 * 1. Create a properties file to hold your properties. It will be a name value pair. New text file:  src/sport.properties. Note the location of the properties file is very important. It must be stored in src/sport.properties
 * 2. Load the properties file in the XML config file.
 * 3. Inject the properties values into your Swim Coach: SwimCoach.java
 * @author mehdi
 *
 */
@Component
public class FortuneServiceImpl implements FortuneService {

	@Value("${foo.fortune.one}")
	private String fortuneOne;
	
	@Value("${foo.fortune.two}")
	private String fortuneTwo;
	
	@Value("${foo.fortune.three}")
	private String fortuneThree;
	
	private String fortunes[];
		
	/**
	 * NOTE: JAVA 9 USERS HEADS UP
	 * If you are using Java 9 and want to make use of @PostConstruct annotation, then you'll need to add support for @PostConstruct. See this link for how to set it up.
	 * https://www.udemy.com/spring-hibernate-tutorial/learn/v4/t/lecture/9120288?start=0
	 */
	@PostConstruct
	private void setUp() {
		fortunes = new String[] {fortuneOne, fortuneTwo, fortuneThree};
	}
	
	public String getFortune() {
		int index = new Random().nextInt(fortunes.length);
		return fortunes[index];
	}

}
