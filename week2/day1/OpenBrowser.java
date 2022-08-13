package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
			driver.manage().window().maximize();
			
		WebElement elementUserName = driver.findElement(By.id("username"));
		elementUserName.sendKeys("Demosalesmanager");
		
		WebElement elementPassword = driver.findElement(By.id("password"));
		elementPassword.sendKeys("crmsfa");
		
		WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
		elementLogin.click();
		
		WebElement elementWelcomeMessage = driver.findElement(By.tagName("h2"));
		String text = elementWelcomeMessage.getText();
	System.out.println(text);
	
	WebElement elementcrmsfa = driver.findElement(By.linkText("CRM/SFA"));
	elementcrmsfa.click();
	
	WebElement elementLeads = driver.findElement(By.linkText("Leads"));
	elementLeads.click();
	
	WebElement elementCreateLeads = driver.findElement(By.linkText("Create Lead"));
	elementCreateLeads.click();
	
	WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
	elementCompanyName.sendKeys("MK Software Solutions");
	
	WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
	elementFirstName.sendKeys("Maheswari");
	
	WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
	elementLastName.sendKeys("Kannan");
	
	WebElement elementSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
	elementSource.sendKeys("Direct Mail");
	
	WebElement elementMarketingIndexDd = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
	Select dd = new Select (elementMarketingIndexDd);
	dd.selectByIndex(4);
	
	WebElement elementIndustryDd = driver.findElement(By.id("createLeadForm_industryEnumId"));
	Select dd1 = new Select (elementIndustryDd);
	dd1.selectByVisibleText("Aerospace");
	
	WebElement elementOwnershipDd = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
	Select dd2 = new Select (elementOwnershipDd);
	dd2.selectByValue("OWN_SCORP");
	
	WebElement elementCreateButton = driver.findElement(By.name("submitButton"));
	elementCreateButton.click();
	
	
		
		

}
}
