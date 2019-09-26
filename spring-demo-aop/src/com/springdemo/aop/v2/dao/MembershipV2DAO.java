package com.springdemo.aop.v2.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipV2DAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOINGMY DB WORK: MEMBESHIP MY ACCOUNT");
	}
	
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOINGMY DB WORK: silly MEMBESHIP MY ACCOUNT");
		return true;
	}
}
