package sk.itsovy.dolinsky.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.dolinsky.hibernate.entity.Student;

/**
 * @author Martin Dolinsky
 */
public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating 3 students objects...");
			Student tempStudent = new Student("John", "Doe", "paul@luv2code.com");
			Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
			Student tempStudent3 = new Student("Bonita", "Applebaum", "bonita@luv2code.com");
			session.beginTransaction();

			System.out.println("Saving the students...");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}
}
