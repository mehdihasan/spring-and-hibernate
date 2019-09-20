package com.springdemo.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// query student
			List<Student> students = session.createQuery("from Student").list();
			
			// display students
			displayStudents(students);
			
			// query student firstname mehdi
			students = session.createQuery("from Student s where s.firstName='Mehdi'").list();
			
			displayStudents(students);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student tempStudent: students) {
			System.out.println(tempStudent);
		}
	}

}
