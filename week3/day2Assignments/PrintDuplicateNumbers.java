package week3.day2Assignments;

import java.util.Set;
import java.util.TreeSet;

public class PrintDuplicateNumbers {
public static void main(String[] args) {
//	data
	int [] data = {4,3,6,8,29,1,2,4,7,8};
	
//	creating a treeset
	Set <Integer> unique = new TreeSet<Integer>();
	
//	creating a set to store the duplicates
	Set <Integer> dup = new TreeSet<Integer>();
	
//	adding values to the Treeset
	for (int i = 0; i<data.length;i++) {
		if (unique.contains(data[i])) {
			dup.add(data[i]);
		}
		else {
			unique.add(data[i]);
		}
	}
	
	System.out.println("The Unique values are " + unique);
	System.out.println("The duplicate values are " + dup);
	
}
}
