package com.springdemo6.scopeandlifecyclewithannotation;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.springdemo1.setup.Coach;

@Component
@Scope("prototype")
public class SwimmingCoach implements Coach/*, BeanPostProcessor*/ {

	@Value("${foo.fortune.one}")
	private String fortuneOne;
	
	@Value("${foo.fortune.two}")
	private String fortuneTwo;
	
	@Value("${foo.fortune.three}")
	private String fortuneThree;
	
	private String fortunes[];
	
	// will run 1st
	@PostConstruct
	private void setup() {
		System.out.println("}} SETUP Swimming coach: Just after initialization");
	}
	
	@Override
	public String getDailyWorkout() {
		return "}} Practice swimming for 1 hour everyday";
	}

	@PostConstruct
	@Override
	public String getDailyFortune() {
		fortunes = new String[] {fortuneOne, fortuneTwo, fortuneThree};
		int index = new Random().nextInt(fortunes.length);
		System.out.println("}} swimming coach fortune: " + fortunes[index]);
		return fortunes[index];
	}
	
	// will not run
	@PreDestroy
	private void cleanUp() {
		System.out.println("}} run this for cleanup - Swimming!");
	}
	
	/*
	// will run 2nd - basically it will run for couple of times
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("}} post Process Before Initialization");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	// will run 3rd - basically it will run for couple of times as well 
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("}} post Process After Initialization");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	*/

}
