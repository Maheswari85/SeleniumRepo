package org.system;

public class Desktop extends Computer {
public void deskTopSize(String size) {
	System.out.println("My Desktop Size is " + size);
	
}

public static void main(String[] args) {
	Desktop sz = new Desktop();
	sz.computerModel("Dell Vostro 143000");
	sz.deskTopSize("14 Inches");
	
	System.out.println("  ");
	Computer mod = new Computer ();
	mod.computerModel("Hp" );
	
}
}
