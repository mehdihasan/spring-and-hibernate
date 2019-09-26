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

	@Before("execution(public void com.springdemo.aop.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n==========>>> Executing @Before advice on addAccount()");
	}
	
	@Before("execution(public void add*())")
	public void runBeforeAppAddAccountAdvice() {
		System.out.println("\n+++++++++++>>> Executing @Before advice on ALL methods starts with add");
	}
	
	@Before("execution(* add*())")
	public void runBeforeAppAddAccountAdviceWithAnyReturnType() {
		System.out.println("\n************>>> Executing @Before advice on ALL methods starts with add");
	}
	
	@Before("execution(* add*(com.springdemo.aop.Account))")
	public void runBeforeAppAddAccountAdviceWithAnyReturnTypeAndAccountParam() {
		System.out.println("\n}}}}}}}}}}}}}>>> Executing @Before advice on methods starts with add and takes parameter Account");
	}
	
	@Before("execution(* add*(com.springdemo.aop.Account, ..))")
	public void runBeforeAppAddAccountAdviceWithAnyReturnTypeAndTwoParam() {
		System.out.println("\n}}--}}--}}>>> Executing @Before advice on methods starts with add and takes parameter Account");
	}
}
