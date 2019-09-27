package com.springdemo.aop.after_returning.v1;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springdemo.aop.after_returning.v1.Account;

/**
 * 
 * @author mehdi
 *
 * Target Object
 *
 */
@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public List<com.springdemo.aop.after_returning.v1.Account> findAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		
		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account("Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");
		Account temp4 = new Account("Staffan", "Gold");
		Account temp5 = new Account("Fred", "Diamod");
		
		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);
		accounts.add(temp4);
		accounts.add(temp5);
		
		return accounts;
	}
	
	public void addAccount() {
		System.out.println(getClass() + ":------> DOINGMY DB WORK: ADDING MY ACCOUNT");
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
