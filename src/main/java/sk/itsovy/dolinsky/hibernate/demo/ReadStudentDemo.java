package sk.itsovy.dolinsky.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.dolinsky.hibernate.entity.Student;


/**
 * @author Martin Dolinsky
 */
public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("Creating student object...");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
			session.beginTransaction();

			System.out.println("Saving student object...");
			System.out.println(tempStudent);
			session.save(tempStudent);

			session.getTransaction().commit();


			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Getting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}
}
