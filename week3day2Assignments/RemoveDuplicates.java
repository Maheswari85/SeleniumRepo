package week3.week3day2Assignments;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
public static void main(String[] args) {
	
//	declaring the string
	
	String text = "PayPal India";
	
//	creating an array to store the string
	
	char [] charlist = new char [text.length()];
	
	for (int i=0; i <text.length(); i++) {
		charlist [i] = text.charAt(i);
		
	}
	System.out.println( charlist);
	
//	Declare a Set as charSet for Character
	Set <Character> charSet  = new LinkedHashSet <Character>();
	
//	Declare a Set as dupCharSet for duplicate Character
	Set <Character> dupCharSet = new LinkedHashSet <Character>();
	
//	iterate to add it to the charSet 
//	if the character is already in the charSet then, add it to the dupCharSet
	
	for (char eachChar : charlist) {
		if (charSet.contains(eachChar)) {
			
			dupCharSet.add(eachChar);
		}
		else {
		charSet.add(eachChar);
		}
		
		}


	System.out.println("Char Set  = " + charSet);
	System.out.println("Dup Char Set = " + dupCharSet);
	
	
			
		
//Check the dupCharSet elements and remove those in the charSet

for(char each:dupCharSet)
{
	if (charSet.contains(each))
		charSet.remove(each);
}

System.out.println("The new char set = " + charSet);

//to remove space from charset
Set <Character> newCharSet = new LinkedHashSet<Character>();
for (char eachunique:charSet ) {
	if (eachunique != ' ') {
		newCharSet.add(eachunique);
	}
}
System.out.println("The char set without the spaces = " + newCharSet );
}
}

