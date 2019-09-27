package com.springdemo.aop.after_throwing.v1;

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
		List<Account> accounts = null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
			System.out.println("\n\nMain Program: Aftre Throwing Demo App");
			System.out.println("--------");
			System.out.println(accounts);
			System.out.println("\n\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// close the context
		context.close();
	}

}
