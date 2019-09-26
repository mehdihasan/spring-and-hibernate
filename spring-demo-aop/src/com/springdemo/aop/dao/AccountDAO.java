package com.springdemo.aop.dao;

import org.springframework.stereotype.Component;

import com.springdemo.aop.Account;

/**
 * 
 * @author mehdi
 *
 * Target Object
 *
 */
@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOINGMY DB WORK: ADDING MY ACCOUNT");
	}
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ":}}}}}}} DOINGMY DB WORK: ADDING MY ACCOUNT ");
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ":}}--}}--}} DOINGMY DB WORK: ADDING VIP ACCOUNT ");
	}
	
	public void goSleep() {
		System.out.println(getClass() + "Go to bed!");
	}
}
