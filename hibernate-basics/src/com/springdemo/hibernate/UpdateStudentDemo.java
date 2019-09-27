package com.springdemo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class UpdateStudentDemo {

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
			Student tempStudent = new Student("Koly", "Mustafa", "koly@kolymustafa.me");
			System.out.println("Student created");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(tempStudent);
			System.out.println("Student saved: " + tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// --- NEW CODE
		
			// get a new session???
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve the student based on id
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("\n\nDB student - before update: " + myStudent);
			
			// UPDATE
			myStudent.setEmail("kolymustafa@yahoo.com");
			System.out.println("\n\nDB student - after update: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// UPDATE - bulk
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update Email for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
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
