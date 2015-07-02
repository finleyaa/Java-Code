package demo;

public class Fibonnaci extends Calculator{
	public void fib() throws InterruptedException{
		int num1 = 1;
		int num2 = 1;
		System.out.println(num1);
		Thread.sleep(500);
		System.out.println(num2);
		Thread.sleep(500);
		while (true){
			System.out.println(num1 + num2);
			num1 = num1 + num2;
			Thread.sleep(500);
			System.out.println(num1 + num2);
			num2 = num1 + num2;
			Thread.sleep(500);
		}
	}
	public void calc(){
		Calculator sub = new Calculator();
		sub.calc();
	}
}