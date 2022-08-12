package week1.day2;

public class Car {

	public void printCarBrand() {
		System.out.println("Tata");
	}
	
	public String getCarColor() {
		return "Maroon";
	}
	
	public int getEngineNum() {
		return 346578934;
	}
		
	public int subTwoNum(int a,int b) {
		int c=a-b;
		return c;
	}
	
	public int mulTwoNum (int d, int e) {
		int F = d*e;
		return F;
	}
	
	public int divTwoNum (int g, int h) {
		int I = g/h;
		return I;
		
	}
	public static void main (String[]args) {
//		creating a new object for the class Car
		
		Car obj = new Car();
		
//	to print the car Brand
		obj.printCarBrand();
		
//	to print the color of the car	
		String carColor = obj.getCarColor();
		System.out.println(carColor);

// to print the engine number		
		
		int engineNumber = obj.getEngineNum();
		System.out.println(engineNumber);

//		to print the subtraction of two numbers
		
		int subNum = obj.subTwoNum(67,22);
		System.out.println(subNum);

//		to print the product of two numbers
		int mulNum = obj.mulTwoNum(10, 2);
		System.out.println(mulNum);
		
//		to print the division of two numbers
		
		int divNum = obj.divTwoNum(50,5);
		System.out.println(divNum);
		
				
		
		
		
	}
	
	
	}

