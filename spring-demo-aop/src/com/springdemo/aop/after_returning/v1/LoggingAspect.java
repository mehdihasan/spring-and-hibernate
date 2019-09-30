package com.springdemo.aop.after_returning.v1;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@AfterReturning(
			pointcut = "execution(* com.springdemo.aop.after_returning.v1.AccountDAO.findAccounts(..))", 
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n======>>> result is: " + result);
		
		// post process data
		if (result != null 
				&& result.size() > 0) {
			convertAccountNamesToUpperCase(result);
		}
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
	}
}
