package demo;

import java.util.Scanner;

public class ScientificCalc extends ScientificFuncs{
	public static void main(String[] args) throws InterruptedException{
		ScientificFuncs sub = new ScientificFuncs();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the operation you want to perform: ");
		String operation = scanner.next();
		
		switch(operation){
		case("calculator"):
			sub.calc();
			break;
		case("pythagoras"):
			sub.pythag();
			break;
		case("fibonacci"):
			sub.fib();
			break;
		}
		scanner.close();
	}
}
