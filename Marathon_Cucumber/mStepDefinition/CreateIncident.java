package mStepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class CreateIncident {
	 public ChromeDriver driver;
	public Shadow shadow;
	public String text;
	public String text2;
	public Select select;
	public WebElement eleFrame;
	public WebElement eleFrame2;
	public WebElement numberDropDown;
	public Select numberDD;
	
	@And("Click on Create new option and fill the mandatory fields")
	public void createincident() {
		eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		text2 = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("New Incident Number :"+ text2);
		driver.findElement(By.id("incident.short_description")).sendKeys("Created via Automation");
		
	}
	@When("Submit button is clicked")
	public void submit() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.switchTo().defaultContent();	
	}
	@Then("New Incident should be available for search")
	public void newIncident() {
		eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(eleFrame2);
		numberDropDown = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);	
	}

	@And("Confirm incident exists")
	public void confirm() {
		 text = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println("Confirming Incident Number from Search " +text); 
if (text2.contains(text)){
	System.out.println("The incident has been created and verified successfully ");
}
else {
	System.out.println("Failed to find the New incident created.");
}
		
	}
}
