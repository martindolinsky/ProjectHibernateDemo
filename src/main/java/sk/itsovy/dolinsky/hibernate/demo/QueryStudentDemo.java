package sk.itsovy.dolinsky.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.dolinsky.hibernate.entity.Student;

import java.util.List;


/**
 * @author Martin Dolinsky
 */
public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<Student> students = session.createQuery("from Student").getResultList();

			displayStudents(students);

			students = session.createQuery("from Student where lastName = 'Doe'").getResultList();
			System.out.println("\n\nStudents with lastname: Doe");
			displayStudents(students);

			students = session.createQuery("from Student where lastName = 'Doe' OR firstName = 'Daffy'").getResultList();
			System.out.println("\n\nStudents with lastname: Doe or firstname: Daffy");
			displayStudents(students);

			students = session.createQuery("from Student where email like '%luv2code.com'").getResultList();
			System.out.println("\n\nStudents with email: %luv2code.com");
			displayStudents(students);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
