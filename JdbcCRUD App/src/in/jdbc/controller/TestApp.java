package in.jdbc.controller;

import java.util.Scanner;

import in.jdbc.service.IStudentService;
import in.jdbc.servicefactory.StudentServiceFactory;

// controller logic
public class TestApp {

	public static void main(String[] args) {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student name : ");
		String sname = scanner.next();
		System.out.print("Enter the student age : ");
		int sage = scanner.nextInt();
		System.out.print("Enter the student address : ");
		String saddress = scanner.next();
		String addStudent = studentService.addStudent(sname, sage, saddress);
		if (addStudent.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed.....");
		}
	}
}
