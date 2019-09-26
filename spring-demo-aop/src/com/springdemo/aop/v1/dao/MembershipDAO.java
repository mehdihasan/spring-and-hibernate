package com.springdemo.aop.v1.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOINGMY DB WORK: MEMBESHIP MY ACCOUNT");
	}
	
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOINGMY DB WORK: silly MEMBESHIP MY ACCOUNT");
		return true;
	}
}
