package com.springdemo10.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdemo01.setup.Coach;

/**
 * @author mehdi
 * 
 * @objective: 
 * 1. Java configuration of spring beans manually (without component scan & not defining components / using @Bean annotation)
 * 2. Injecting values form properties file
 * 
 * @steps
 * 1. define method to expose bean (BeanHolder.java)
 * 2. inject bean dependencies (BeanHolder.java)
 * 3. read spring java configuration class (HockeyJavaConfigDemoApp.java)
 * 4. retrieve bean from Spring container (HockeyJavaConfigDemoApp.java)
 * 
 * @issues on injecting properties values Spring version below 4.3
 * you need to add the following code to resolve the issue
 * 
   // add support to resolve ${...} properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer
                    propertySourcesPlaceHolderConfigurer() {
        
        return new PropertySourcesPlaceholderConfigurer();
    }
 * 
 */
public class HockeyJavaConfigDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanHolder.class);
		
		Coach hockeyCoach = context.getBean("hockeyCoach", Coach.class);
		System.out.println(hockeyCoach.getDailyFortune());
		System.out.println(hockeyCoach.getDailyWorkout());
		
		context.close();
	}

}
