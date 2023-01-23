package in.jdbc.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.jdbc.dto.Student;
import in.jdbc.util.JdbcUtil;

//persistence logic using JDBC API
public class StudentDaoImpl implements IStudentDao {

	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

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
		String sqlSelectQuery = "select id,name,age,address from student where id = ?";
		Student student = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, sid);
			}
			if (pstmt != null) {
				rs = pstmt.executeQuery();
			}
			if (rs != null) {
				if (rs.next()) {
					student = new Student();
					// copy resultSet data to student object
					student.setSid(rs.getInt(1));
					student.setSname(rs.getString(2));
					student.setSage(rs.getInt(3));
					student.setSaddress(rs.getNString(4));
					return student;
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		String sqlDeleteQuery = "delete from student where id = ?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, sid);

				int executeUpdate = pstmt.executeUpdate();

				if (executeUpdate == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}
}
