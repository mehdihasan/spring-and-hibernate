package com.springdemo.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 
 * @author mehdi
 * 
 * class to define our Advices
 */
@Aspect
@Component
public class DemoLoggingAspect {

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n==========>>> Executing @Before advice on addAccount()");
	}
}
