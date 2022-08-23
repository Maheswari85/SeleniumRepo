package week3.week3day2Assignments;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {
public static void main(String[] args) {

//	Taking name as input
	String name = "Maheswari";
	
//	Creating a Character array
	
	char [] characterArray = new char[name.length()];
	
//	adding the name characters to the array
	
	for (int i = 0; i<name.length();i++) {
		
		characterArray[i] = name.charAt(i);
	}
	
	System.out.println(characterArray);
	
//	 Creating a new HashSet
	Set <Character> nameSet = new HashSet <Character>();
	
//	adding each character to the set and if it is already there, remove it
	
	for (int i = 0; i <characterArray.length; i++) {
		if (nameSet.contains(characterArray[i])) {
			
			nameSet.remove(characterArray[i]);
		}
		else {
			nameSet.add(characterArray[i]);
		}
		
		
		
	}
	
//	Finally, printing the set
	System.out.println(nameSet);
	
}
}
