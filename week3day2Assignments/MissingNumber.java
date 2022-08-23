package week3.week3day2Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {
public static void main(String[] args) {
//	data 
	int [] data = {3,2,5,6,9,3,1,4,8,10};
//	converting it into Treeset to get rid of the duplicates
	Set <Integer> set = new TreeSet<Integer>();
	
	for (int num:data) {
		int eachnum = num;
		set.add(eachnum);
	}
		
	System.out.println("The set created with unique values :" +set);	
		
//	converting the set to list
	List <Integer> list = new ArrayList<Integer> (set);
	
	System.out.println("The converted list is "+ list);
	
//	to find out the missing number
	
	for (int i=0; i<list.size();i++) {
		
		int a = list.get(i);
		int b = a+1;
		
		if (b == list.get(i+1)) {
			
			continue;
		}
		
		else {
			System.out.println("The missing number is "+b);
			break;
			
		}
		
	}
	
}
}
