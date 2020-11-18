package sk.itsovy.dolinsky.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.dolinsky.hibernate.entity.Student;


/**
 * @author Martin Dolinsky
 */
public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");
			session.beginTransaction();

			System.out.println("Saving student object...");
			session.save(tempStudent);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}
}
