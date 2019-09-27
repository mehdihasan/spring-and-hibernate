package com.springdemo.aop.around.v1;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.springdemo.aop.around.v1.*.getFortune(..))")
	public void pointCut() {}
	
	@Around("pointCut()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out advice method
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @After (finally) on method: " + method);
		
		// begin timestamp
		long begin  = System.currentTimeMillis();
		
		// execute the method
		Object result;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			//e.printStackTrace();
			logger.warning(e.getMessage());
			result = "Major Accident! But no worries! Your private helicopter is on the way!";
			
			// re-throw the exception
			throw e;
		}
		
		// end timestamp
		long end  = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		
		logger.info("\n===>>>>>>> Duration of the program: " + duration / 1000 + " second(s)");
		
		return result;
	}
	
}
