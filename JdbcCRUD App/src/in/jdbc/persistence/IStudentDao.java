package in.jdbc.persistence;

import in.jdbc.dto.Student;

public interface IStudentDao {
	// operation to be implemented
	public String addStudent(String sname, Integer sage, String saddress);

	public Student searchStudent(Integer sid);

	public String updateStudent(Student student);

	public String deleteStudent(Integer sid);
}
