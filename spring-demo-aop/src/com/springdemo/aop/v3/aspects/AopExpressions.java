package com.springdemo.aop.v3.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.springdemo.aop.v3.dao.*.*(..))")
	public void forV3DaoPackage() {}
	
	@Pointcut("execution(* com.springdemo.aop.v3.dao.*.get*(..))")
	public void forV3AllGet() {}
	
	@Pointcut("execution(* com.springdemo.aop.v3.dao.*.set*(..))")
	public void forV3AllSet() {}
	
	@Pointcut("forV3DaoPackage() && !(forV3AllGet() || forV3AllSet())")
	public void noGetterOrSetter() {}
}
