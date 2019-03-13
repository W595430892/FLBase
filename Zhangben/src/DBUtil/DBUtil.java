package DBUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
		public  static  Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/zhangben? ?characterEncoding=utf-8&useSSL=true";
			Connection connection = null;
			try {
				 connection = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
		public static void close(Connection connection ) {
			try {
				if (connection != null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(Statement Statement ) {
			try {
				if (Statement != null) {
					Statement.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void close(ResultSet resultSet ) {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}




