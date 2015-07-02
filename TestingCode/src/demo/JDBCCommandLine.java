package demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Statement;

public class JDBCCommandLine {
	public static void main(String[] args) throws SQLException{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdatabase", "root", "$Password1$");
		
		Scanner scanner = new Scanner(System.in);
		
		while (true){
			System.out.println("Query or update?: ");
			String queUp = scanner.next(); 
			switch(queUp){
			case("Query"):
			case("query"):
				System.out.println("Input SQL Query: ");
				String sql = scanner.next();
				Statement stmt = connection.createStatement();
				
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					String 
				}
			}
		}
	}
}
