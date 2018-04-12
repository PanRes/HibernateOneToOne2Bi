package gr.pr.udemy.hibernate.onetoone.main;

import gr.pr.udemy.hibernate.onetoone.models.Instructor;
import gr.pr.udemy.hibernate.onetoone.models.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class,1);
			
			if (instructor != null) {
				session.delete(instructor);
			}
			
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
