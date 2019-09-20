package com.springdemo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Oroni", "Hasan", "oroni@mehdihasan.me");
			System.out.println("Student created");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			System.out.println("Student saved: " + tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// --- NEW CODE
			
			// find out the new student's id: primary key
			System.out.println("Saved student id: " + tempStudent.getId());
			
			// get a new session???
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("DB student: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("DONE!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
