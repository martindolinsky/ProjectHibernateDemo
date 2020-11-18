package sk.itsovy.dolinsky.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Martin Dolinsky
 */
public class TestJDBC {
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:8889/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!");
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
