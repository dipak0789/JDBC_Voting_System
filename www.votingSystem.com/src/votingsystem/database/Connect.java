package votingsystem.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	static Connection co;
	public static Connection getConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			co = DriverManager.getConnection("jdbc:mysql://localhost:3306/votingsystem", "root", "root@1234");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return co;
	}
	
}
