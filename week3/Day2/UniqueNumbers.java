package week3.Day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNumbers {
public static void main(String[] args) {
	
	
	List <Integer> numlist = new ArrayList<Integer> ();
	
	numlist.add(1);
	numlist.add(22);
	numlist.add(3);
	numlist.add(54);
	numlist.add(65);
	numlist.add(22);
	numlist.add(43);
	numlist.add(67);
	numlist.add(98);
	numlist.add(1);
	
	List<Integer> duplist = new ArrayList <Integer> ();
	
//	to identify the duplicate numbers in the list
	 for (int i = 0; i< numlist.size(); i++) {
		 
		 int eachNum = numlist.get(i);
		 
		 for (int j = i +1; j<numlist.size() ; j++) {
			int everyNum = numlist.get(j);
			
			if (eachNum == everyNum ) {
				
				duplist.add(eachNum);
				
			}
		 }

	 }
//	to print the duplicate numbers
	System.out.println("The duplicate numbers in this list : "+ duplist );

//	to print only the unique numbers
	
	Set <Integer> numset = new TreeSet <Integer> (numlist);
	System.out.println("The unique values in the list using Set :" +numset );
	}
	
	
	
}
