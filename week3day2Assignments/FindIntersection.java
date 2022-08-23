package week3.week3day2Assignments;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {
public static void main(String[] args) {
//	declaring 2 set of array
	
	int[] a = {3,2,11,4,6,7};
	int[] b = {1,2,8,4,9,7};
	
//	creating list1
	List<Integer> list1 = new ArrayList<Integer> ();
	
//	creating list 2
    List<Integer> list2 = new ArrayList<Integer>();
    
//	to add the array1 elements into the list
	for (int eachNum1:a) {
		
		list1.add(eachNum1);
	}
	
//to add array2 elements into the list
	for(int eachNum2:b ) {
		list2.add(eachNum2);
	}
	
//	creating a list to store the output
	List <Integer> IntersectedValues = new ArrayList<Integer> ();
	
// creating a nested loop to find the intersected value
	for (int eachList1:list1) {
		for (int eachlist2:list2) {
			
			if (eachList1==eachlist2) {
				IntersectedValues.add(eachList1);
				 
				}
			
		}
		
	}
	
	System.out.println("The intersected values are " + IntersectedValues);
	
	
	
	
}
}
