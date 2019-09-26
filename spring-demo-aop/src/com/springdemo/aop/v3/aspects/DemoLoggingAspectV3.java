package com.springdemo.aop.v3.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aop.v3.Account;

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
	public void beforeAddAccountAdviceV3(JoinPoint joinPoint) {
		
		System.out.println("\n==========>>> Executing @Before advice on addAccount() V3");
		
		// display method signature
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + signature);
		
		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object tempArg: args) {
			System.out.println(tempArg);
			
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				
				System.out.println("account name: " + account.getName());
				System.out.println("account level: " + account.getLevel());
			}
		}
	}
}
