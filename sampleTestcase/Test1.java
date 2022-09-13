package sampleTestcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Test1 extends ProjectSpecificMethods {

	@Test
	public void runcreate() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dilip");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("V R");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("98");
		driver.findElement(By.name("submitButton")).click();
	}
	
}
