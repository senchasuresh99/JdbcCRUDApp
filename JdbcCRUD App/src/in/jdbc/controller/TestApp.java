package in.jdbc.controller;

import java.util.Scanner;

import in.jdbc.dto.Student;
import in.jdbc.service.IStudentService;
import in.jdbc.servicefactory.StudentServiceFactory;

// controller logic
public class TestApp {

	public static void main(String[] args) {
		// insertOperatation();
		// selectOperatation();
		//deleteOperatation();
		updateOperatation();
	}

	private static void updateOperatation() {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id : ");
		int sid = scanner.nextInt();
		System.out.print("Enter the student name : ");
		String sname = scanner.next();
		System.out.print("Enter the student age : ");
		int sage = scanner.nextInt();
		System.out.print("Enter the student saddress : ");
		String saddress = scanner.next();
		String addStudent = studentService.updateStudent(sid, sname, sage, saddress);
		if (addStudent.equalsIgnoreCase("success")) {
			System.out.println("record Updated succesfully");
		} else {
			System.out.println("record updation failed.....");
		}
		scanner.close();
	}
	
	@SuppressWarnings("unused")
	private static void deleteOperatation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id to be deleted : ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		String status = studentService.deleteStudent(sid);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("record deleted succesfully");
		} else if (status.equalsIgnoreCase("not found")) {
			System.out.println("record not avilable for the given id : " + sid);
		} else {
			System.out.println("record deletion failed.....");
		}
		scanner.close();

	}

	@SuppressWarnings("unused")
	private static void selectOperatation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id : ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(sid);
		if (student != null) {
			System.out.println(student);
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSage() + "\t"
					+ student.getSaddress());
		} else {
			System.out.println("Record not found the given id : " + sid);
		}
		scanner.close();
	}

	@SuppressWarnings("unused")
	private static void insertOperatation() {
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
		scanner.close();
	}
}
