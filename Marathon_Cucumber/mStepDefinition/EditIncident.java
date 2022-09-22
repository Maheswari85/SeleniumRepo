package mStepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class EditIncident {
	public WebDriver driver;
	public Shadow shadow;
	public String exID;
	public String ConfmId;
	public String descptn;
	public String state;
	public String urgncycode;
	public Select select;
	public Select urgencyDD;
	public Select statusDD;
	public Select numberDD;
	public WebElement eleFrame;
	public WebElement existingincident;
	public WebElement eleCallerID;
	public WebElement urgency;
	public WebElement status;
	public WebElement eleShortDesc;
	public WebElement srchDD;
	@And("select an Incident to be edited")
	public void selectIndnt() {
		eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		existingincident =driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']"));
		exID = existingincident.getText();
		existingincident.click();
	}
	@And("Edit the Status, Short Description,caller and Urgency fields")
	public void edit() throws InterruptedException {
		eleCallerID = driver.findElement(By.id("sys_display.incident.caller_id"));
		eleCallerID.clear();
		eleCallerID.sendKeys("abel",Keys.TAB);
		Thread.sleep(1000);
		
		urgency = driver.findElement(By.xpath("//select[@id ='incident.urgency']"));
		urgencyDD=new Select(urgency);
		urgencyDD.selectByVisibleText("1 - High");
		
		System.out.println("The urgency option selected is '1 - High'");
		
		status = driver.findElement(By.xpath("//select[@name = 'incident.state']"));
		statusDD=new Select(status);
		statusDD.selectByVisibleText("In Progress");
		System.out.println("The Status selected is 'In Progress'" );
		eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys("Edited Via Automation");
		System.out.println("Short Description entered is 'Edited via Automation'" );	
	}
	
	@And("Click on update button")
	public void update() {
		driver.findElement(By.xpath("//button[text()='Update']")).click();	
	}
	
	@When("Edited incident is searched")
	public void searchedited() {
		driver.findElement(By.xpath("//b[text() = 'All']")).click();
		srchDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		numberDD=new Select(srchDD);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(exID,Keys.ENTER);	
	}
	
	@Then("Incident with the updated details should be displayed.")
	public void resultupdated() {
		ConfmId = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		descptn = driver.findElement(By.xpath("//td[@class ='vt'][3]")).getText();
		state = driver.findElement(By.xpath("//td[@class ='vt'][5]")).getText();
		urgncycode = driver.findElement(By.xpath("//td[@class ='vt'][6]")).getText();
		
		if (ConfmId.contains(exID)) {
			System.out.println("Id verified sucessfully.");
		}
		else {
			System.out.println("Id not matching.");
		}
		if (descptn.contains("Edited Via Automation")) {
			System.out.println("Short Description verified sucessfully.");
		}	
	}
}
