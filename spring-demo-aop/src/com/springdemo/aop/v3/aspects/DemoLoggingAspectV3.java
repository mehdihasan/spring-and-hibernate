package com.springdemo.aop.v3.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 
 * @author mehdi
 * 
 * class to define our Advices with generalized pointcut
 */
@Aspect
@Component
@Order(2)
public class DemoLoggingAspectV3 {

	@Before("com.springdemo.aop.v3.aspects.AopExpressions.forV3DaoPackage()")
	public void beforeAddAccountAdviceV3() {
		System.out.println("\n==========>>> Executing @Before advice on addAccount() V3");
	}
}
