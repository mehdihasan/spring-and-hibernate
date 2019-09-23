package com.springdemo.hibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

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
			
			// create  a course
			Course course = new Course("Karate course");
			
			
			
			// save the course
			session.save(course);
			
			// create students
			Student student1 = new Student("John", "Doe", "jhon@doe.com");
			Student student2 = new Student("Mary", "Public", "mary@public.com");
			
			
			
			// add students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			
			// saving students
			session.save(student1);
			session.save(student2);
			
			
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
