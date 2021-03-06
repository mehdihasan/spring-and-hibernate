package com.springdemo.hibernate.one_to_one_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DetailDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			int theId = 6;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("\n\n\n>> This is insructor detail: " + instructorDetail);
			
			System.out.println("\n\n\n>> This is associated isntructor: " + instructorDetail.getInstructor());
			
			session.delete(instructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
