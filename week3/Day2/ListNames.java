package week3.Day2;

import java.util.ArrayList;
import java.util.List;

public class ListNames<E> {
	public static void main(String[] args) {
		List <String> list = new ArrayList <String>();
	    list.add("Karthi");
	    list.add("Aru");
	    list.add("Dev");
	    list.add("Selva");
	    list.add("Anbu");
	    list.add("Sekar");
	    
	    for (String name : list)
	    {
	    	if (name.startsWith("S"))
	    		System.out.println(name);
	    }
	   
	}
	
	
    
    
    
}
