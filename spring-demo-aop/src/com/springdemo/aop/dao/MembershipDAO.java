package com.springdemo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOINGMY DB WORK: MEMBESHIP MY ACCOUNT");
	}
}
