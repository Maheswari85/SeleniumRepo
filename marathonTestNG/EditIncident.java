package marathonTestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.github.sukgu.Shadow;
import testingAttributes.ProjectSpecificMethods;

public class EditIncident extends ProjectSpecificMethods {
	
	@BeforeTest(alwaysRun = true )
	
	public void setData() {
		excelFileName = "EditIncident";
	}
	
	@Test(dataProvider = "sendData")
	public void runEdit(String code,String Qstatus, String Details) throws InterruptedException {

		
		//4. Search for the existing incident and click on the incident
		Shadow shadow = new Shadow(driver);
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
	
		WebElement existingincident =driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']"));
		String exID = existingincident.getText();
		existingincident.click();
		
		//5. Update the incident with Urgency as High and State as In Progress
		WebElement eleCallerID = driver.findElement(By.id("sys_display.incident.caller_id"));
		eleCallerID.clear();
		eleCallerID.sendKeys("abel",Keys.TAB);
		Thread.sleep(1000);
		
		WebElement urgency = driver.findElement(By.xpath("//select[@id ='incident.urgency']"));
		Select urgencyDD=new Select(urgency);
		urgencyDD.selectByVisibleText(code);
		
		System.out.println("The urgency option selected is " + code);
		
		WebElement status = driver.findElement(By.xpath("//select[@name = 'incident.state']"));
		Select statusDD=new Select(status);
		statusDD.selectByVisibleText(Qstatus);
		
		System.out.println("The Status selected is  " + Qstatus);
		
		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys(Details);
		
		System.out.println("Short Description entered is " + Details);
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();	
		
		//6. Verify the updated information is available in the incident
		
		driver.findElement(By.xpath("//b[text() = 'All']")).click();
		WebElement srchDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(srchDD);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(exID,Keys.ENTER);
		

		String ConfmId = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		String descptn = driver.findElement(By.xpath("//td[@class ='vt'][3]")).getText();
		String state = driver.findElement(By.xpath("//td[@class ='vt'][5]")).getText();
		String urgncycode = driver.findElement(By.xpath("//td[@class ='vt'][6]")).getText();
		
		if (ConfmId.contains(exID)) {
			System.out.println("Id verified sucessfully.");
		}
		else {
			System.out.println("Id not matching.");
		}
		if (descptn.contains("Edited Via Automation")) {
			System.out.println("Short Description verified sucessfully.");
		}
		else {
			System.out.println("Description not matching");
		}
		if (state.contains("In Progress")) {
			System.out.println("Status verified sucessfully.");
		}
		else {
			System.out.println("Status not matching");
		}
		
		if (urgncycode.contains("1 - High")) {
			System.out.println("Urgency verified sucessfully.");
		}
		else {
			System.out.println("Urgency not matching");
		}
		
	}
}
