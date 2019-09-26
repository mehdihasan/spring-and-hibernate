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
		accountDAO.addAccount();
		accountDAO.addAccount(new Account());
		accountDAO.addAccount(new Account(), true);
		
		membershipDAO.addAccount();
		membershipDAO.addSillyMember();
		
		// close the context
		context.close();
	}

}
