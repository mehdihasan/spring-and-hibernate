package com.springdemo.aop.dao;

import org.springframework.stereotype.Component;

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
}
