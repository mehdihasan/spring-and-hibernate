package com.springdemo.aop.v2.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * @author mehdi
 * 
 * class to define our Advices with generalized pointcut
 */
@Aspect
@Component
public class DemoLoggingAspectV2 {
	
	@Pointcut("execution(* com.springdemo.aop.v2.dao.*.*(..))")
	public void forV2DaoPackage() {}
	
	@Pointcut("execution(* com.springdemo.aop.v2.dao.*.get*(..))")
	public void forV2AllGet() {}
	
	@Pointcut("execution(* com.springdemo.aop.v2.dao.*.set*(..))")
	public void forV2AllSet() {}
	
	@Pointcut("forV2DaoPackage() && !(forV2AllGet() || forV2AllSet())")
	public void noGetterOrSetter() {}

	@Before("forV2DaoPackage()")
	public void beforeAddAccountAdviceV2() {
		System.out.println("\n==========>>> Executing @Before advice on addAccount() V2");
	}
	
	@Before("noGetterOrSetter()")
	public void performApiAnalytics() {
		System.out.println("\n==========>>> Perform AIP analytics V2");
	}
}
