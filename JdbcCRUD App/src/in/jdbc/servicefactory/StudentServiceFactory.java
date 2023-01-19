package in.jdbc.servicefactory;

import in.jdbc.service.IStudentService;
import in.jdbc.service.StudentServiceImpl;

//Connection connection = DrivarManager.getConnection(url,username,password);
// Abstraction logic of Implementation
public class StudentServiceFactory {
	// make constructor private to avoid object creation
	public StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() {
		// singleton pattern code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}
}
