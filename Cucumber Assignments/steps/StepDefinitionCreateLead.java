package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionCreateLead {
ChromeDriver driver;
String leadID;
@Given("Chrome browser is opened")
public void openBrowser() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
}

@Given("Load the application url as {string}")
public void loadURL(String url) {
	driver.get(url);
}

@Given("Maximize and set the timeouts")
public void maxandTimeout() {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
}
@And("Enter Username as {string}")
public void username(String username) {
	WebElement usernamefield = driver.findElement(By.id("username"));
	usernamefield.sendKeys(username);
}
@And("Enter Password as {string}") 
public void password(String password) {

	WebElement passwordfield = driver.findElement(By.id("password"));
	passwordfield.sendKeys(password);
} 
@And("click Login Button")
public void Loginbutton() {
	WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
	loginbutton.click();
}

@And("Click on CRMSFA link")
public void click_on_crmsfa_link() {
	driver.findElement(By.linkText("CRM/SFA")).click();
}
@And ("Click on Leads Tab")
public void click_on_leads_tab(){
	driver.findElement(By.linkText("Leads")).click();
}
@And("Click on Create Lead")
public void click_on_create_lead() {
	driver.findElement(By.linkText("Create Lead")).click();
}
@And("Enter Company Name as {string}")
public void CompanyName (String companyName) {
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);	
}
@And("Enter  Forename as {string}")
public void Forename (String foreName ) {
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(foreName);	
}
@And("Enter Surname as {string}")
public void Surname (String surName) {
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(surName);	
}

@When("Create button is clicked")
public void clkCreatebutton () {
	driver.findElement(By.name("submitButton")).click();	
}
@Then("Error message is displayed")
public void ChkErrorMgs() {
	WebElement errmsg = driver.findElement(By.xpath("//div[text () = 'The Following Errors Occurred:']"));
	String errText = errmsg.getText();
	if (errText.contains("The Following Errors Occurred")) {
		System.out.println("Error Message Displayed Successfully");
	}
	else {
		System.out.println("Incorrect Error Message");
		}
	}
	
@Then("View Lead page is displayed")
public void view_lead_page_is_displayed()  {
		String pagetitle = driver.getTitle();
	if (pagetitle.contains("View Lead")) {
		System.out.println("New Lead has been created or updated successfully");
	}
	else {
		System.out.println("Failed to create New Lead");
	}
	}
@And("click on Find Leads Tab")
public void ClkFindLeadsTab() {
	driver.findElement(By.linkText("Find Leads")).click();
}
@And("click on Phone Tab")
public void clkPhoneNumberTab() {
	driver.findElement(By.xpath("//span[text()='Phone']")).click();	
}
@And("Enter Phone number in the phone number field")
public void EnterPhoneNumber() {
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");	
}
@And("click on Find Lead button")
public void ClkFindLeadButton() throws InterruptedException {
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();	
	Thread.sleep(2000);
}
@And("Get the Lead ID for the first search result")
public void GetLeadID() {
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();	
}
@And("Click on the first Lead ID in the result")
public void ClkFirstLeadId() {
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();	
}
@And("click on Delete option")
public void clkDeleteOption() {
	driver.findElement(By.linkText("Delete")).click();	
}
@And ("Click on Find Lead Tab")
public void ClkFindLeadTab() {
	driver.findElement(By.linkText("Find Leads")).click();	
}

@And ("Input the LeadID that was deleted")
public void InputLeadID() {
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);	
}
@When("click on Find Lead")
public void clkFindLeadTab() {
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();	
}
@Then("Get the message displayed")
public void ErrorMessage() throws InterruptedException {
	Thread.sleep(1000);
	String recordMessage = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
	if(recordMessage.equals("No records to display"))
	System.out.println("Lead deleted Successfully");
	else {
		System.out.println("Lead is not deleted");
}
}
@And("click on Edit Lead")
public void EditLeadBtn() {
	driver.findElement(By.linkText("Edit")).click();	
}
@And("Update the companyName as {string}")
public void UpdateCompName(String CompanyName) {
	WebElement elementNewCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
	elementNewCompanyName.clear();
	elementNewCompanyName.sendKeys(CompanyName);	
}
@When("Click on Update Button")
public void ClkUpdateBtn() {
	driver.findElement(By.name("submitButton")).click();	
}
@And("click on Duplicate Lead")
public void ClkDuplicateBtn() {
	 driver.findElement(By.linkText("Duplicate Lead")).click();
		
}
@And("Click on Merge Leads")
public void mergeLead() {
	driver.findElement(By.xpath("//a[text()='Merge Leads']")).click();
}
@And("Select From and To Leads from the lookup table")
public void leadsSelectionforMerge() throws InterruptedException {
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("hari");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles.get(0));
	
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("babu");
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));
}

@When("Merge Button is clicked and Alert Message is accepted")
public void ClkMergeButton() {
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();
}
@And("Close Browser")
public void closeBrowser() {
	driver.close();
}
}








