package com.springdemo.web.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
		
		// display the args to the method
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		
		// loop through and display the arguments
		for (Object tempArg: args) {
			logger.info("==============> in @Before: with argument: " + tempArg);
		}
	}
	
	
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		// display method we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n========> in @AfterReturning: calling method: " + method);
		
		// display the return data
		logger.info("\\n========> in @AfterReturning return data: " + result);
	}
}
