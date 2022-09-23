package marathonTestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.sukgu.Shadow;
import testingAttributes.ProjectSpecificMethods;

public class CreateInstance extends ProjectSpecificMethods{
	@BeforeTest(alwaysRun = true )
	public void setData() {
		excelFileName = "CreateIncident";
	}
	public Shadow shadow;
	@Test(dataProvider = "sendData")
	
	public  void runCreate(String Describe) throws InterruptedException {

		//5. Click on Create new option and fill the mandatory fields
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("New Incident Number :"+text2);
		driver.findElement(By.id("incident.short_description")).sendKeys(Describe);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();

		//6. Verify the newly created incident by getting the incident number and put it in search field and 
		

		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		WebElement numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		//driver.switchTo().defaultContent();

		//Confirm incident exists !
		//	driver.switchTo().frame("gsft_main");
		String text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println("Confirming Incident Number from Search " +text); 
		if (text2.contains(text)){
		System.out.println("The incident has been created and verified successfully ");
		}
		else {
			System.out.println("Failed to find the New incident created.");
		}
		
		}
}
