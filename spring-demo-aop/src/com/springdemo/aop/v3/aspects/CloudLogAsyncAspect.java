package com.springdemo.aop.v3.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

	@Before("com.springdemo.aop.v3.aspects.AopExpressions.noGetterOrSetter()")
	public void logToCloudAsync() {
		System.out.println("\n==========>>> Log to cloud async V3");
	}
}
