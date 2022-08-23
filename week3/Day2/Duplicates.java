package week3.Day2;

import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.util.Integers;

public class Duplicates {
public static void main(String[] args) {
	
	List <Integer> numlist = new ArrayList<Integer>();
	numlist.add(1);
	numlist.add(22);
	numlist.add(3);
	numlist.add(43);
	numlist.add(22);
	numlist.add(65);
	numlist.add(54);
	
	List<Integer> duplist = new ArrayList <Integer> ();
	for (int i = 0; i< numlist.size(); i++) {
		 
		 int eachNum = numlist.get(i);
		 
		 for (int j = i +1; j<numlist.size() ; j++) {
			int everyNum = numlist.get(j);
			
			if (eachNum == everyNum ) {
				
				duplist.add(eachNum);	
			
		}
	}
	
	
}
	System.out.println("The duplicate number in this list : "+ duplist );

}
}
