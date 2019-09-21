package com.springdemo.hibernate.one_to_one_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.one_to_one_uni.entity.Instructor;
import com.springdemo.hibernate.one_to_one_uni.entity.InstructorDetail;

public class DeleteDemo {

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
			
			// create a object
			Instructor instructor = new Instructor("Mehdi", "Hasan", "mehdi@hasan.com");
			InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com", "code");
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
			
			// get instructor
			session = factory.getCurrentSession();
			session.beginTransaction();
			Instructor dbInstructor = session.get(Instructor.class, instructor.getId());
			if (dbInstructor != null) {
				System.out.println("Instructor found: " + dbInstructor);
				
				// Note: will also delete associated "details" object
				// because of Cascade.All
				session.delete(dbInstructor);
			}
			session.getTransaction().commit();
			
			session.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
