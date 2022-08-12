package week1.day2;

public class IsPrime {
	public static void main(String[] args) {
		int n = 10;
			
			if (n==0) {
			System.out.println("0 is neither a Prime nor a composite");
		}
		else if (n==1) {
			System.out.println("1 is a Prime Number");
		}
		else if (n==2) {
		
			System.out.println("2 is a Prime Number");
		}
		else if (n>2) {
			
			boolean flag = true;
			for (int i=2;i<=n-1;i++) {
				
				if (n%i == 0) {
					flag = false;
				}
			}
				if (flag) {
					System.out.println("The given number is a prime number");
				}
				else {
					System.out.println("The given number is not a prime number");
				}
			

					
					
		}
			
			
		}
	}


