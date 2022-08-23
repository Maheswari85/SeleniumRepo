package week3.day2Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SecondLargestNumber {
public static void main(String[] args) {
	
	int[] data = {3,2,11,4,6,7,2,3,3,6,7};
//	creating a TreeSet to store the above data
	
	Set<Integer> set = new TreeSet<Integer>();
	for (int i=0; i< data.length; i++) {
		int num = data[i];
		set.add(num);
	}
	
	System.out.println("The new Set created using TreeSet is "+ set);
	
//to convert into List
	List <Integer> list = new ArrayList<Integer>(set);
	
	System.out.println("The converted list is "+ list);
	
//	to get the second last
	
	int secondLastNum = list.get(list.size()-2);
	
	System.out.println("The second last Number of the list is "+ secondLastNum );
}
	
	
	
}
