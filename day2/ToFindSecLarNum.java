package week1.day2;

import java.util.Arrays;

public class ToFindSecLarNum {
public static void main(String[] args) {
	
//	declaring the num array
	
	int []num = {22,67,98,1,34,58,99};
	
//	sort the num array
		Arrays.sort(num);
		
//	find the length of the array
		int size = num.length;

//		print the second largest number in the given array
	System.out.println("The second largest number in the given array is "+(num[size-2]));
}
}
