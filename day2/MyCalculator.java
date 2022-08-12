package week1.day2;

public class MyCalculator {
	
	public static void main(String[] args) {
		//creating an object for the class Calculator
		Calculator answer = new Calculator();
		//calling the method addInt
		int addition  = answer.addInt(22,35 ,98);
		System.out.println("Addition of the three integers is "+addition); 
		
		//calling the method subInt
		int subtraction = answer.subInt(78, 34);
		System.out.println("The subtraction of the two integers is "+ subtraction);
		
//		calling the method mulnum
		double product = answer.mulnum(56.06, 23.987);
		System.out.println("The multiplication of the given numbers is "+ product);
		
//		calling the method divNum
		float division = answer.divNum(45.56783f, 8.43567f);
		System.out.println("The answer for the division of the given numbers is "+ division);
		
		
	}

}
