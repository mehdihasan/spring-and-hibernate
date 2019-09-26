package com.springdemo.aop.v2.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipV2DAO {

	private String name;
	
	public void addAccount() {
		System.out.println(getClass() + ": DOINGMY DB WORK: MEMBESHIP MY ACCOUNT");
	}
	
	public boolean addSillyMember() {
		System.out.println(getClass() + ": DOINGMY DB WORK: silly MEMBESHIP MY ACCOUNT");
		return true;
	}
	
	public void setName(String name) {
		System.out.println("//////////////  SETTING NAME");
		this.name = name;
	}
	
	public String getName() {
		System.out.println("//////////////  GETTING NAME");
		return name;
	}
}
