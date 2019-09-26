package com.springdemo.aop.v3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.v3.dao.AccountV3DAO;
import com.springdemo.aop.v3.dao.MembershipV3DAO;


public class MainDemoAppV3 {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfigV3.class);
		
		// get the bean from spring container
		AccountV3DAO accountDAO = context.getBean("accountV3DAO", AccountV3DAO.class);
		
		MembershipV3DAO membershipDAO = context.getBean("membershipV3DAO", MembershipV3DAO.class);
		
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
		membershipDAO.setName("MEHDI");
		System.out.println("--------------------------- END ---------------------------");
		membershipDAO.getName();
		System.out.println("--------------------------- END ---------------------------");
		
		// close the context
		context.close();
	}

}
