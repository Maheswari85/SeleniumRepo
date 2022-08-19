package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v94.browser.Browser;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class EditLead {

	
		public static void main(String[] args)  {
			
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				driver.get("http://leaftaps.com/opentaps/control/main");
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
				
								
				WebElement elementFindLeads = driver.findElement(By.xpath("//a[contains (text(),'Find Leads')]"));
				elementFindLeads.click();
				
								
				WebElement elementNameField = driver.findElement(By.xpath("(//input[@name='firstName'])[3]"));
				elementNameField.sendKeys("Kannan");
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				WebElement elementFindLeadsButton = driver.findElement(By.xpath("//button[text () = 'Find Leads']"));
				elementFindLeadsButton.click();
				System.out.println("Pressed Find Lead Button Successfully");
								
				WebElement elementFirstValue= driver.findElement(By.xpath("(//a[@class = 'linktext'])[4]"));
				elementFirstValue.click();
				
				String title = driver.getTitle();
				System.out.println(title);
				
				if (title.contains("View Lead | opentaps CRM"))  {
					
					System.out.println("Page Name verified successfully" ) ;
				}
				
				WebElement elementEditButton= driver.findElement(By.xpath("//a[contains(text(),'Edit')]"));
				elementEditButton.click();
				
				WebElement elementNewCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
				elementNewCompanyName.clear();
				elementNewCompanyName.sendKeys("Harshad Solutions 123");
				String updatedCompanyName = elementNewCompanyName.getText();
				
				WebElement elementUpdateButton= driver.findElement(By.xpath("//input[@value = 'Update']"));
				elementUpdateButton.click();
				
				String newCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
				
				System.out.println("Updated Company Name is "+ newCompanyName );
				
				if (newCompanyName.contains(updatedCompanyName) )  {
					System.out.println("The Company Name has been updated successfully");
				}
				
				
		}
}
				