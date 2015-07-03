package demo;

import java.sql.*;

public class Connect extends NewEmployee{
	public static void main(String[] args) throws SQLException{
		NewEmployee employ = new NewEmployee();
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdatabase", "root", "$Password1$");
		
	}
}
