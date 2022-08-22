package org.Bank;

public class AxisBank extends BankInfo {
	public void deposit()
	{
	System.out.println("We offer personal loan at less percentage");	
	}

	public void accountInfo () {
	
		System.out.println("The values of Axis bank class bank info is :");
	
		this.deposit();
		
		System.out.println("  ");
		System.out.println("The values of  BankInfo class is");
		super.deposit();
		
		
	}
	public static void main(String[] args) {
		AxisBank acc = new AxisBank();
		acc.accountInfo();
		System.out.println("  ");
		acc.fixed();
		acc.saving();
		acc.deposit();
		
          
		
	}
	
}
