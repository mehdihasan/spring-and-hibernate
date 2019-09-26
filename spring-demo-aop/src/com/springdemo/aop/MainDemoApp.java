package com.springdemo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.dao.AccountDAO;
import com.springdemo.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method 
		// calling target twice to check aspect is being executed as per our @Before advice
		accountDAO.addAccount();
		System.out.println("--------------------------- END ---------------------------");
		accountDAO.addAccount();
		System.out.println("--------------------------- END ---------------------------");
		accountDAO.addAccount(new Account());
		System.out.println("--------------------------- END ---------------------------");
		accountDAO.addAccount(new Account(), true);
		System.out.println("--------------------------- END ---------------------------");
		
		membershipDAO.addAccount();
		System.out.println("--------------------------- END ---------------------------");
		membershipDAO.addSillyMember();
		System.out.println("--------------------------- END ---------------------------");
		
		// close the context
		context.close();
	}

}
