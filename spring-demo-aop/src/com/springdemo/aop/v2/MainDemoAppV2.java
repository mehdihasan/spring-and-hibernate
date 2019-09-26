package com.springdemo.aop.v2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aop.v2.dao.AccountV2DAO;
import com.springdemo.aop.v2.dao.MembershipV2DAO;


public class MainDemoAppV2 {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfigV2.class);
		
		// get the bean from spring container
		AccountV2DAO accountDAO = context.getBean("accountV2DAO", AccountV2DAO.class);
		
		MembershipV2DAO membershipDAO = context.getBean("membershipV2DAO", MembershipV2DAO.class);
		
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
