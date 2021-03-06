package database.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USER = "root";
	private static final String PASSWORD = "miye210902,.";
	private Connection conn = null;
	
	public DBConnection() throws Exception {
		try {
			Class.forName(Driver);
			this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Connection getConnection() {
		return this.conn;
	}
	
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
