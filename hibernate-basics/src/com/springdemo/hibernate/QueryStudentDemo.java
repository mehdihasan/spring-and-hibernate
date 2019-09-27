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

			// query student & display students
			List<Student> students = session.createQuery("from Student").list();
			displayStudents(students);
			
			// query student firstname mehdi & display
			System.out.println("\n\n\nStudent whose firstName Mehdi");
			students = session.createQuery("from Student s where s.firstName='Mehdi'").list();
			displayStudents(students);
			
			// 
			System.out.println("\n\n\nStudents whose firstName Mehdi OR lastName Hasan");
			students = session.createQuery("from Student s where s.firstName='Mehdi' OR s.lastName='Hasan'").list();
			displayStudents(students);
			
			// 
			System.out.println("\n\n\nStudent whose email ends witn asan.me");
			students = session.createQuery("from Student s where s.email LIKE '%asan.me'").list();
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
