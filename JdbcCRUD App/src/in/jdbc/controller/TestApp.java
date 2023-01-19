package in.jdbc.controller;

import in.jdbc.service.IStudentService;
import in.jdbc.servicefactory.StudentServiceFactory;

// controller logic
public class TestApp {

	public static void main(String[] args) {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String addStudent = studentService.addStudent("Suresh", 24, "Pali");
		if (addStudent.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed.....");
		}
	}
}
