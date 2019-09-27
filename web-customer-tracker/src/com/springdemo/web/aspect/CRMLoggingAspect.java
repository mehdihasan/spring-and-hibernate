package com.springdemo.web.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.springdemo.web.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.springdemo.web.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.springdemo.web.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n========> in @Before: calling method: " + method);
	}
	
	// add @AfterReturning advice
}
