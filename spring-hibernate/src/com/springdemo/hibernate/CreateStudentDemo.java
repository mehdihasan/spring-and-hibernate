package com.springdemo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create a student object
			Student tempStudent = new Student("Mehdu", "Hasan", "mail@mehdihasan.me");
			System.out.println("Student created");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			System.out.println("Student saved");
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
