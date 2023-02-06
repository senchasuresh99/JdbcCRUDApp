package in.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.jdbc.dto.Student;
import in.jdbc.service.IStudentService;
import in.jdbc.servicefactory.StudentServiceFactory;

// controller logic
public class TestApp {

	public static void main(String[] args) throws IOException {
		while (true) {
			BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("ENTER 1 TO INSERT THE VALUES");
			System.out.println("ENTER 2 TO SELECT THE VALUES");
			System.out.println("ENTER 3 TO DELETE THE VALUES");
			System.out.println("ENTER 4 TO UPDATE THE VALUES");
			System.out.println("ENTER 5 TO EXITE");
			System.out.print("ENTER THE NUMBER : ");
			String options = scanner.readLine();

			switch (options) {
			case "1":
				insertOperatation();
				break;
			case "2":
				selectOperatation();
				break;
			case "3":
				deleteOperatation();
				break;
			case "4":
				updateOperatation();
				break;
			case "5":
				System.out.println("********** THANKS FOR USING THE APPLICATIN **********");
				System.exit(0);
			default:
				System.err.println("INVALID OPTION PLEASE TRY AGAIN WITH VALID OPTION...");
				break;
			}
		}
	}

	private static void updateOperatation() throws IOException {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("ENTER THE STUDENT ID TO BE UPDATE: ");
		String sid = scanner.readLine();
		Student searchStudent = studentService.searchStudent(Integer.parseInt(sid));
		if (searchStudent != null) {
			Student newStudent = new Student();
			System.out.println("Student id is : " + searchStudent.getSid());
			newStudent.setSid(searchStudent.getSid());

			System.out.print("Student old name is : " + searchStudent.getSname() + " Enter New Name : ");
			String newName = scanner.readLine();
			if (newName.equalsIgnoreCase("") || newName == "") {
				newStudent.setSname(searchStudent.getSname());
			} else {
				newStudent.setSname(newName);
			}
			System.out.print("Student old age is : " + searchStudent.getSage() + " Enter New Age : ");
			String newAge = scanner.readLine();
			if (newAge.equalsIgnoreCase("") || newAge == "") {
				newStudent.setSage(searchStudent.getSage());
			} else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.print("Student old address is : " + searchStudent.getSaddress() + " Enter New address : ");
			String newAddress = scanner.readLine();
			if (newAddress.equalsIgnoreCase("") || newAddress == "") {
				newStudent.setSaddress(searchStudent.getSaddress());
			} else {
				newStudent.setSaddress(newAddress);
			}
			String updateStudent = studentService.updateStudent(newStudent);
			if (updateStudent.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully");
			} else {
				System.err.println("record updation failed.....");
			}
		} else {
			System.err.println("Student record not available for given id : " + sid);
		}
	}

	private static void deleteOperatation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id to be deleted : ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		String status = studentService.deleteStudent(sid);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("record deleted succesfully");
		} else if (status.equalsIgnoreCase("not found")) {
			System.err.println("record not avilable for the given id : " + sid);
		} else {
			System.err.println("record deletion failed.....");
		}
	}

	private static void selectOperatation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the student id : ");
		int sid = scanner.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent(sid);
		if (student != null) {
			// System.out.println(student);
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			System.out.println(student.getSid() + "\t" + student.getSname() + "\t" + student.getSage() + "\t"
					+ student.getSaddress());
		} else {
			System.err.println("Record not found the given id : " + sid);
		}
	}

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
			System.err.println("record insertion failed.....");
		}
	}
}
