package marathonTestNG;



//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;


import io.github.sukgu.Shadow;
import testingAttributes.ProjectSpecificMethods;

public class DeleteIncident extends ProjectSpecificMethods{
	
	
	@Test()
	public  void runDelete()throws InterruptedException {

		//5.Select an incident for deletion
		Shadow shadow = new Shadow(driver);
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		WebElement existingincident =driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']"));
		String exID = existingincident.getText();
		System.out.println("The incident ID selected for deletion is : " + exID);
		existingincident.click();

		//6. Delete the incident
		shadow.findElementByXPath("//button[text()='Delete']").click();
		
		driver.findElement(By.id("ok_button")).click();

		//7. Verify the deleted incident
		driver.findElement(By.xpath("//b[text() = 'All']")).click();
		WebElement srchDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(srchDD);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(exID,Keys.ENTER);
		
		
		String msg = driver.findElement(By.className("list2_empty-state-list")).getText();
		System.out.println(msg);
		
		if (msg.contains("No records to display")) {
			System.out.println("Incident Deleted Sucessfully.");
		}
		else {
			System.out.println("Incident Deletion unsucessful.");
		}
	}

}
