package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractice {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			
			WebElement elementUserName = driver.findElement(By.xpath("//input[@class = 'inputLogin']"));
			elementUserName.sendKeys("Demosalesmanager");
			
			WebElement elementPassword = driver.findElement(By.xpath("//input[@type = 'password']"));
			elementPassword.sendKeys("crmsfa");
			

			WebElement elementLogin = driver.findElement(By.xpath("//input[@type = 'submit']"));
			elementLogin.click();
			
			WebElement elementcrmsfa = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
			elementcrmsfa.click();
			
			WebElement elementLeads = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
			elementLeads.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement elementCreateLead = driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]"));
			elementCreateLead.click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement elementCompanyName = driver.findElement(By.xpath("//input[@id = 'createLeadForm_companyName']"));
			elementCompanyName.sendKeys("KMH Solutions");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement elementFirstName = driver.findElement(By.xpath("//input[@id = 'createLeadForm_firstName']"));
			elementFirstName.sendKeys("Harshad");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			WebElement elementLastName = driver.findElement(By.xpath("//input[@id = 'createLeadForm_lastName']"));
			elementLastName.sendKeys("Kannan");
			
			WebElement elementFirstNameLocal = driver.findElement(By.id("createLeadForm_firstNameLocal"));
			elementFirstNameLocal.sendKeys("Kannan Simman");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
						
			WebElement elementCreate = driver.findElement(By.xpath("//input[@class = 'smallSubmit']"));
			elementCreate.click();
			
	}
}
