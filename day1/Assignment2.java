package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			
			WebElement elementUserName = driver.findElement(By.id("username"));
			elementUserName.sendKeys("Demosalesmanager");
			
			WebElement elementPassword = driver.findElement(By.id("password"));
			elementPassword.sendKeys("crmsfa");
			

			WebElement elementLogin = driver.findElement(By.className("decorativeSubmit"));
			elementLogin.click();
			
			WebElement elementcrmsfa = driver.findElement(By.linkText("CRM/SFA"));
			elementcrmsfa.click();
			
			WebElement elementLeads = driver.findElement(By.linkText("Leads"));
			elementLeads.click();
			
			WebElement elementCreateLead = driver.findElement(By.linkText("Create Lead"));
			elementCreateLead.click();
			
			WebElement elementCompanyName = driver.findElement(By.id("createLeadForm_companyName"));
			elementCompanyName.sendKeys("KMH Solutions");
			
			WebElement elementFirstName = driver.findElement(By.id("createLeadForm_firstName"));
			elementFirstName.sendKeys("Harshad");
			
			WebElement elementLastName = driver.findElement(By.id("createLeadForm_lastName"));
			elementLastName.sendKeys("Kannan");
			
			WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
			elementFirstNameLocal.sendKeys("Kannan Simman");
			
			WebElement elementDepartmentName = driver.findElement(By.id("createLeadForm_departmentName"));
			elementDepartmentName.sendKeys("Quality Assurance");
			
			WebElement elementDescription = driver.findElement(By.name("description"));
			elementDescription.sendKeys("Quality Assurance Team does its best.");
			
			WebElement elementPrimaryEmail = driver.findElement(By.name("primaryEmail"));
			elementPrimaryEmail.sendKeys("Test@gmail.com");
			
			WebElement elementStateOrProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select drpdwn = new Select(elementStateOrProvince);
			drpdwn.selectByVisibleText("New York");
			
			
			WebElement elementCreate = driver.findElement(By.name("submitButton"));
			elementCreate.click();
			
			WebElement elementDuplicateLeads = driver.findElement(By.linkText("Duplicate Lead"));
			elementDuplicateLeads.click();
			
			WebElement elementDuplicateName = driver.findElement(By.id("createLeadForm_companyName"));
			elementDuplicateName.clear();
			elementDuplicateName.sendKeys("Kannan Solutions");
			
			WebElement elementCreateDuplicateLeads = driver.findElement(By.name("submitButton"));
			elementCreateDuplicateLeads.click();
			
			String title = driver.getTitle();
			System.out.println(title);
			
}
}
