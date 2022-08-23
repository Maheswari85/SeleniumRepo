package week3.Day2;

import java.util.HashMap;
import java.util.Map;

public class TestLeaf {
public static void main(String[] args) {
	String text = "testleaf";
	Map <Character,Integer > map = new HashMap <Character,Integer> ();
	for (int i = 1; i<text.length();i++) {
		
		if (map.containsKey(text.charAt(i))) {
			map.put(text.charAt(i), map.get(text.charAt(i))+1);
		
		}
		
		else {
			map.put(text.charAt(i), 1);
		}
	}
	System.out.println(map);
	
	
	
	
	
	
	
	
	
	
	
}
}
