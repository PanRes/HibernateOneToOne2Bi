package gr.pr.udemy.hibernate.onetoone.main;

import gr.pr.udemy.hibernate.onetoone.models.Instructor;
import gr.pr.udemy.hibernate.onetoone.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Panagiotis", "Ressos","pr@pr.gr");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/panres","programing");
			
			instructor.setInstructorDetailId(instructorDetail);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
			
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
		
	}
}
