package in.jdbc.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws IOException, SQLException {
		FileInputStream fis = new FileInputStream(
				"src\\application.properties");
		Properties ps = new Properties();
		ps.load(fis);

		Connection connection = DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("username"),
				ps.getProperty("password"));
		System.out.println("connection object created...");
		return connection;
	}

	public static void cleanUp(Connection conn, PreparedStatement pstmt, ResultSet rs) throws SQLException {
		if (conn != null) {
			conn.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}
