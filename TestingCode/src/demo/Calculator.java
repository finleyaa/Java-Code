package demo;

import java.util.Scanner;
import java.lang.Math;

public class Calculator {
	public void calc(){
		// Create a scanner.
		Scanner scanner = new Scanner(System.in);
		
		// Read the users input.
		System.out.println("Enter an expression (in the form 3 * 5 etc.) 2 // 3 for sqrt of 3: ");
		double num1 = scanner.nextDouble();
		String operation = scanner.next();
		double num2 = scanner.nextDouble();
		// Operator switch
		switch(operation){
		case("+"):
			System.out.println(num1 + num2);
			break;
		case("-"):
			System.out.println(num1 - num2);
			break;
		case("*"):
			System.out.println(num1 * num2);
			break;
		case("/"):
			System.out.println(num1 / num2);
			break;
		case("^"):
			System.out.println(Math.pow(num1, num2));
			break;
		case("//"):
			System.out.println(Math.sqrt(num1));
			break;
		// Error case.
		default:
			System.out.println("Error: Invalid operator.");
		}
	}
}
