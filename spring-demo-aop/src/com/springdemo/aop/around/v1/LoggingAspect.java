package com.springdemo.aop.around.v1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.springdemo.aop.around.v1.*.getFortune(..))")
	public void pointCut() {}
	
	@Around("pointCut()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out advice method
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @After (finally) on method: " + method);
		
		// begin timestamp
		long begin  = System.currentTimeMillis();
		
		// execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// end timestamp
		long end  = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		
		System.out.println("\n===>>>>>>> Duration of the program: " + duration / 1000 + " second(s)");
		
		return result;
	}
	
}
