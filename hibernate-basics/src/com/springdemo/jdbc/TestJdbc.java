package com.springdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author mehdi
 *
 * Java 9, 10, 11 user issues: 
 * 1. https://www.udemy.com/spring-hibernate-tutorial/learn/lecture/8759408#announcements
 * 2. https://www.udemy.com/spring-hibernate-tutorial/learn/lecture/9371384#announcements
 */
public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3301/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
