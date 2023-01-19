package in.jdbc.daofactory;

import in.jdbc.persistence.IStudentDao;
import in.jdbc.persistence.StudentDaoImpl;

public class StudentDaoFactory {

	private StudentDaoFactory() {

	}

	private static IStudentDao studentDao = null;

	public static IStudentDao getStudentDao() {
		if (studentDao == null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}
}
