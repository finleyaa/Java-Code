package demo;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class NewEmployee extends Frame implements ActionListener{
	private static boolean truefalse = false;
	private static TextField tLName = new TextField(20);
	private static TextField tJob = new TextField(20);
	private static TextField tSalary = new TextField(20);
	private static boolean loopvar = true;
	private static Frame f = new Frame();
	private static int EmployeeID = 1;
	private static TextField tFName = new TextField(20);
	private static String setTitle = System.getProperty("title");
	// GUI
	NewEmployee(){
		Label lID = new Label("Employee ID: " + EmployeeID);
		Label lFName = new Label("First Name: ");
		Label lLName = new Label("Last Name: ");
		Label lJob = new Label("Job: ");
		Label lSalary = new Label("Salary in £/year: ");
		Button b = new Button("Submit");
		b.addActionListener(this);
		f.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent we) {
	            System.exit(1);
	         }
	     }
		);
		
		f.add(lID);
		f.add(lFName);
		f.add(tFName);
		f.add(lLName);
		f.add(tLName);
		f.add(lJob);
		f.add(tJob);
		f.add(lSalary);
		f.add(tSalary);
		f.add(b);
		f.setExtendedState(MAXIMIZED_BOTH);
		f.setTitle(setTitle);
		f.setLayout(new FlowLayout());
		f.setVisible(true);
		f.pack();
		
	}
	synchronized static boolean loop(){
		return loopvar;
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException{ 
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/testdatabase", "root", "$Password1$");
		String sql = "SELECT ID FROM employees ORDER BY ID DESC LIMIT 1";
		Statement stmt = connection.createStatement();
		ResultSet ID = stmt.executeQuery(sql);
		while(ID.next()){
			EmployeeID = ID.getInt("ID");
			EmployeeID += 1;
		}
		@SuppressWarnings("unused")
		NewEmployee n = new NewEmployee();
		while (loop()){
			if (NewEmployee.truefalse == true){
				String First_name = (NewEmployee.tFName).getText();
				String Last_name = (NewEmployee.tLName).getText();
				String Job = (NewEmployee.tJob).getText();
				String Salary = (NewEmployee.tSalary).getText();
				String sql1 = "INSERT INTO employees(First_name, Last_name, Job, Salary_£PerYear, Join_date)" + 
					  "VALUES(\"" + First_name + "\", \"" + Last_name + "\", \"" + Job + "\", \"" + Salary + "\", CURDATE())";
				Statement update = connection.createStatement();
				@SuppressWarnings("unused")
				int rs = update.executeUpdate(sql1);
				System.out.println("Update Complete.");
				System.exit(1);
			}
		}
	}
	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		if(action.equals("Submit")){
			NewEmployee.truefalse = true;
		}
	}
}
