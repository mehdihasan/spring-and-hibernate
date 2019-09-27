package com.springdemo.aop.after_returning.v1;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = 
						new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// find and display accounts
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("\n\nMain Program: Aftre Returning Demo App");
		System.out.println("--------");
		System.out.println(accounts);
		System.out.println("\n\n");
		
		// close the context
		context.close();
	}

}
