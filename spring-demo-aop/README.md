# Spring AOP
To study AOP features in Spring. 

## Topics covered:
- AOP frameworks (In Java):
	- Spring AOP
	- AspectJ

- **Aspect**: module of code for a cross-cutting concern (logging, security, transactions, caching, analytics, ...)

- **Advice**: What action is taken and when it should be applied.
	- Advice Types:
		- **@Before** advice: run before the method
			- Use case: 
				- Logging, security, transaction 
				- Audit logging
				- API management:  number of method calls, analytics, average load, top user
			- Best practice:
				- Keep the code small
				- Keep the code fast
				- Do not perform any expensive/slow operation
				- Get in and out as quickly as possible
		- **After**: After finally advice: run after the method (finally) whatever returning or throwing.
    	- **@AfterReturning**: After returning advice: run after the method (success execution)
			- Use cases
				- most common: logging, security, transactions
				- audit logging: who, what, when, where
				- post-processing data: 
					- post process the data before returning the caller. 
					- Format the data to enrich the data
		- **@AfterThrowing**: After throwing advice: run after method (if exception thrown)
			- Use cases
				- Log the exception
				- Perform auditing on the exception
				- Notify DevOps team via email or SMS
				- Encapsulate this functionality in AOP aspect for easy reuse
		- **@Around**: Around advice: run before and after method
			- Use case
				- common: logging, auditing, security
				- Pre-processing & post-processing data
				- Instrumentation / profining code (i.e. how long it take for a section of code to run?)
				- Managing exceptions: Swallow / handle / stop exceptions
			- **proceeding joint point**: to handle target method. ***Proceeding joint point*** can be used to execute ***target method***.
			- usage of **Logger**
		- Order of advice: (usage of **@Order** annotation)
			- place Advices in separate Aspects
			- Add **@Order** annotation to Aspects

- **Join Point**: When to apply code during problem execution.

- **Pointcut**: A predicate expression for where advice should be applied. Spring AOP uses AspectJ's pointcut expression language.

```
execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)
``` 

match any method in our DAO package: com.springdemo.aop.dao
```java
@Before("execution(* com.springdemo.aop.dao.*.*(..))")
```

	- **Pointcut Declarations**: To reuse pointcut expressions. Update pointcut in one location. 

- **Weaving**: connecting aspects to target object to create an advice object
	- Types: compile-time, load-time, run-time
	- Regarding performance: run-time weaving is the slowest.


