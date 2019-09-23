package com.springdemo.hibernate.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {		
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor
			int theId = 3;
			Instructor instructor = session.get(Instructor.class, theId);
			
			// create courses
			Course tempCourse1 = new Course("Air Gitar - The ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			
			// add courses to ins
			instructor.addCourse(tempCourse1);
			instructor.addCourse(tempCourse2);
			
			// save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
