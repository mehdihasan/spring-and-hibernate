package com.springdemo.aop.v1.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	@Pointcut("execution(* add*())")
	public void allAdd() {}
	
	@Pointcut("execution(* add*(..))")
	public void allAddWithParam() {}

	@Before("execution(public void com.springdemo.aop.v1.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n==========>>> V1 Executing @Before advice on addAccount()");
	}
	
	@Before("execution(public void add*())")
	public void runBeforeAppAddAccountAdvice() {
		System.out.println("\n+++++++++++>>> V1 Executing @Before advice on ALL methods starts with add");
	}
	
	@Before("allAdd()")
	public void runBeforeAppAddAccountAdviceWithAnyReturnType() {
		System.out.println("\n************>>> V1 Executing @Before advice on ALL methods starts with add");
	}
	
	@Before("execution(* add*(com.springdemo.aop.v1.Account))")
	public void runBeforeAppAddAccountAdviceWithAnyReturnTypeAndAccountParam() {
		System.out.println("\n}}}}}}}}}}}}}>>> V1 Executing @Before advice on methods starts with add and takes parameter Account");
	}
	
	@Before("execution(* add*(com.springdemo.aop.v1.Account, ..))")
	public void runBeforeAppAddAccountAdviceWithAnyReturnTypeAndTwoParam() {
		System.out.println("\n}}--}}--}}>>> V1 Executing @Before advice on methods starts with add and takes parameter Account");
	}
	
	@Before("allAddWithParam()")
	public void runBeforeAppAddAccountAdviceWithAnyReturnTypeAndAnyNumberOfParam() {
		System.out.println("\n}}>>>}}>>>}}>>> V1 Executing @Before advice on methods starts with add and takes parameter Account");
	}
	
	@Before("execution(* com.springdemo.aop.v1.dao.*.*(..))")
	public void runBeforeAllMethodsStartedWithAddIntoSpecificPackage() {
		System.out.println("\\n##### V1 hmmmmm");
	}
}
