package demo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class JDBCExample {
 
  public static void main(String[] argv) throws SQLException {
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("MySQL JDBM Driver not detected.");
		e.printStackTrace();
		return;
	}

	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost/testdatabase", "root", "$Password1$");
 
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("Connection complete.");
	} else {
		System.out.println("Failed to make connection!");
	}
	
	System.out.println("Creating statement...");
	Statement stmt = connection.createStatement();
	
	String sql;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Choose whether to sort by Country_name, Population or Head_of_state: ");
	String sort = scan.next();
	
	if (sort.contains("Population")){
		System.out.println("Changed from \"" + sort + "\" to \"Population\".");
		sort = "Population";
	}
	else if (sort.contains("Country_name")){
		System.out.println("Changed from \"" + sort + "\" to \"Country_name\".");
		sort = "Country_name";
	}
	else if (sort.contains("Head_of_state")){
		System.out.println("Changed from \"" + sort + "\" to \"Head_of_state\".");
		sort = "Head_of_state";
	}
	
	switch(sort){
	case("Population"):
		break;
	case("Head_of_state"):
		break;
	case("Country_name"):
		break;
	default:
		System.out.println("Error: Cannot sort by \"" + sort + "\". Sorting by \"Country_name\" instead.");
		sort = "Country_name";
	}
	
	sql = "SELECT Country_name, Population, Head_of_state FROM countryinfo ORDER BY " + sort;
	
	ResultSet rs = stmt.executeQuery(sql);
	System.out.println("-------------------------------------------------------------------------------------");
	while(rs.next()){
		String Country_name = rs.getString("Country_name");
		int Population = rs.getInt("Population");
		String Head_of_state = rs.getString("Head_of_state");
	
		System.out.println("Country name: " + Country_name + " | Population: " + Population + " | Head of State: " + Head_of_state);
		System.out.println("-------------------------------------------------------------------------------------");
	}
	Statement stmt2 = connection.createStatement();
	//Enter in record
	System.out.println("Enter the country name: ");
	String cname = scan.next();
	System.out.println("Enter the population as an integer: ");
	int pop = scan.nextInt();
	System.out.println("Enter the head of state: ");
	String HoS = scan.next();
	
	sql = "INSERT INTO countryinfo (Country_name, Population, Head_of_state)" + 
		  "VALUES(\"" + cname + "\", " + pop + ", \"" + HoS + "\")";
	@SuppressWarnings("unused")
	int input = stmt2.executeUpdate(sql);
	System.out.println("Update complete.");
	
	sql = "SELECT Country_name, Population, Head_of_state FROM countryinfo WHERE Country_name = \"" + cname + "\"";
	Statement stmtInput = connection.createStatement();
	System.out.println("Statement created.");
	rs = stmtInput.executeQuery(sql);
	System.out.println("Query executed.");
	rs.beforeFirst();
	
	while(rs.next()){
		String Country_nameInput = rs.getString("Country_name");
		int PopulationInput = rs.getInt("Population");
		String Head_of_stateInput = rs.getString("Head_of_state");
		
		String result = "Country_name: " + Country_nameInput + " | Population: " + PopulationInput + " | Head of State: " + Head_of_stateInput;
		System.out.println("Result: " + result);
	}
	
	rs.close();
	stmt.close();
	connection.close();
	scan.close();
	
	
  }
}