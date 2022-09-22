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

public class DeleteIncident {
	public WebDriver driver;
	public Shadow shadow;
	public String exID;
	public Select select;
	public Select numberDD;
	public String msg;
	public WebElement srchDD;
	public WebElement eleFrame;
	public WebElement existingincident;
	
	@And("Select the Incident to be deleted")
	public void selectIncident() {
		eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		existingincident =driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']"));
		exID = existingincident.getText();
		System.out.println("The incident ID selected for deletion is : " + exID);
		existingincident.click();	
	}
	@And("Delete button is clicked")
	public void ClkDelBtn() {
		shadow.findElementByXPath("//button[text()='Delete']").click();
		
	}
	
	@And("system asks for confirmation")
public void confirmAlert() {
		driver.findElement(By.id("ok_button")).click();	
	}
	
	@When("check for the deleted incident")
	public void confirmDeletion() {
		driver.findElement(By.xpath("//b[text() = 'All']")).click();
		srchDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		numberDD=new Select(srchDD);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(exID,Keys.ENTER);	
	}
	@Then("No records to display should be displayed")
public void NoRecordsMessage() {
		msg = driver.findElement(By.className("list2_empty-state-list")).getText();
		System.out.println(msg);
		
		if (msg.contains("No records to display")) {
			System.out.println("Incident Deleted Sucessfully.");
		}
		else {
			System.out.println("Incident Deletion unsucessful.");
		}
	}
	}

