package com.springdemo.hibernate.one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {

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
			
			// create  a course
			Course course = new Course("Pacman - how to score 1 mil");
			
			// add some reviews
			course.addReview(new Review("Great course!"));
			course.addReview(new Review("Not that much!"));
			course.addReview(new Review("Very bad"));
			
			// save the course
			session.save(course);
			
			
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
