package com.springdemo10.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springdemo1.setup.Coach;
import com.springdemo1.setup.FortuneService;
import com.springdemo1.setup.SimpleFortuneService;

/**
 * @author mehdi
 *
 * @question: During All Java Configuration, how does the @Bean annotation work in the background?
 * @answer: At a high-level, Spring creates a bean component manually. By default the scope is singleton. 
 * So any request for a "hockeyCoach" bean, will get the same instance of the bean since singleton 
 * is the default scope.
 * 
 * The @Bean annotation tells Spring that we are creating a bean component manually. We didn't specify a 
 * scope so the default scope is singleton.
 * 
 * This specifies that the bean will bean id of "hockeyCoach". The method name determines the bean id. 
 * The return type is the Coach interface. This is useful for dependency injection. This can help 
 * Spring find any dependencies that implement the Coach interface.
 * 
 * The @Bean annotation will intercept any requests for "hockeyCoach" bean. Since we didn't specify a scope, 
 * the bean scope is singleton. As a result, it will give the same instance of the bean for any requests.
 * 
 * It is important to note that this method has the @Bean annotation. The annotation will intercept ALL 
 * calls to the method "hockeyCoach()". Since no scope is specified the @Bean annotation uses singleton 
 * scope. Behind the scenes, during the @Bean interception, it will check in memory of the Spring 
 * container (applicationContext) and see if this given bean has already been created. 
 * If this is the first 
 * time the bean has been created then it will execute the method as normal. It will also register the bean 
 * in the application context. So that is knows that the bean has already been created before. Effectively 
 * setting a flag. 
 * The next time this method is called, the @Bean annotation will check in memory of the Spring container 
 * (applicationContext) and see if this given bean has already been created. Since the bean has already been 
 * created (previous paragraph) then it will immediately return the instance from memory. It will not execute 
 * the code inside of the method. Hence this is a singleton bean.
 */
@Configuration
public class BeanHolder {
	
	@Bean
	public FortuneService fortuneService() {
		return new SimpleFortuneService();
	}
	
	@Bean
	public Coach hockeyCoach() {
		return new HockyCoach(fortuneService());
	}
}
