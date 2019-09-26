package com.springdemo.aop.v3.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(23)
public class ApiAnalyticsAspect {

	@Before("com.springdemo.aop.v3.aspects.AopExpressions.noGetterOrSetter()")
	public void performApiAnalytics() {
		System.out.println("\n==========>>> Perform AIP analytics V3");
	}
}
