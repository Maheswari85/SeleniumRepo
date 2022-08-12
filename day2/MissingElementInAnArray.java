package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		int [] arr1 = {1,2,3,4,7,6,8};
		Arrays.sort(arr1);
		int count = 1;
		for (int i=0;i<=arr1.length-1;i++) {
			if (arr1[i]!=i+count) {
				System.out.println("The missing element is "+ (i+count));
				count++;
			}
			
				
		}
	}
}
