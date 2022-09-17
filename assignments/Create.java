package week7.day1.assignments;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Create extends ProjectSpecificMethods {
	@BeforeTest(alwaysRun = true )
	public void setData() {
		excelFileName = "Book1";
	}
	
	@Test(dataProvider = "sendData", invocationCount = 2,groups = "regression")
	public  void createpage(String username, String password, String cname, String fname,String lname) {
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
		
}
	

	
	
}
	

