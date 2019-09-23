package com.springdemo.hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// 
			// get instructor
			int theId = 2;
			Student student = session.get(Student.class, theId);
			System.out.println("\n\n\nThe course: " + student);
			
			// get course for instructor
			System.out.println("\n\n\nCourses: " + student.getCourses());
			
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
