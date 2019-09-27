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
		- After finally advice: run after the method (finally)
    	- After running advice: run after the method (success execution)
		- After throwing advice: run after method (if exception thrown)
		- Around advice: run before and after method
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


