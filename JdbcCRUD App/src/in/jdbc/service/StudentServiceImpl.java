package in.jdbc.service;

import in.jdbc.dto.Student;
import in.jdbc.servicefactory.StudentServiceFactory;

//service layer logic
public class StudentServiceImpl implements IStudentService {

	IStudentService studentService;
	
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		studentService = StudentServiceFactory.getStudentService();
		return studentService.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		return null;
	}

}
