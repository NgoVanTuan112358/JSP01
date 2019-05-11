package JDBC_MYSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	public static Connection conn;
	public static Connection connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/nhanvien?autoReconnect=true&useSSL=false";
			String user = "root";
			String password = "Ng0vantuan@iop100895";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
