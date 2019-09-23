package com.springdemo.hibernate.one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetReviewCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// 
			// get instructor
			int theId = 12;
			Course course = session.get(Course.class, theId);
			System.out.println("\n\n\nThe course: " + course);
			
			// get course for instructor
			System.out.println("\n\n\nCourses: " + course.getReviews());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE!!!\n\n\n");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}

}
