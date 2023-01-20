package in.jdbc.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.jdbc.dto.Student;
import in.jdbc.util.JdbcUtil;

//persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement pstmt = null;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		String sqlInsertQuery = "insert into student(`name`,`age`,`address`)values(?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddress);

				int executeUpdate = pstmt.executeUpdate();

				if (executeUpdate == 1) {
					return "success";
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return "Failure";
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
