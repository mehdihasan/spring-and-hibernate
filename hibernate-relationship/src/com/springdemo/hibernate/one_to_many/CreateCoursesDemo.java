package com.springdemo.hibernate.one_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
			
			// create a object
			Instructor instructor = new Instructor("Jacob", "Suntal", "jacob@suntal.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/ass", "Video Game");
			System.out.println("Objects created");
			
			// associate objects together
			instructor.setInstructorDetail(instructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(instructor);
			System.out.println("Instructor & Details saved");
			
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
