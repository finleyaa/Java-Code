package demo;

import java.util.Scanner;
import java.lang.Math;

public class ScientificFuncs extends Fibonnaci{
	public void fib() throws InterruptedException{
		Fibonnaci sub = new Fibonnaci();
		sub.fib();
	}
	public void pythag() throws InterruptedException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the 2 numbers for pythagoras in the form \"2 , 3\": ");
		double first_num = scanner.nextDouble();
		@SuppressWarnings("unused")
		String buffer = scanner.next();
		double second_num = scanner.nextDouble();
		
		double result = ((first_num*first_num)+(second_num*second_num));
		
		result = Math.sqrt(result);
		
		System.out.println(result);
		
		scanner.close();
	}
	public void calc(){
		Fibonnaci sub = new Fibonnaci();
		sub.calc();
	}
}
