package week4.day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class MergeContacts {
	/*
	 * //Pseudo Code
	 * 	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 	 * 2. Enter UserName and Password Using Id Locator
	 * 	 * 3. Click on Login Button using Class Locator
	 * 	 * 4. Click on CRM/SFA Link
	 * 	 * 5. Click on contacts Button
	 * 	 * 6. Click on Merge Contacts using Xpath Locator
	 * 	 * 7. Click on Widget of From Contact
	 * 	 * 8. Click on First Resulting Contact
	 * 	 * 9. Click on Widget of To Contact
	 * 	 * 10. Click on Second Resulting Contact
	 * 	 * 11. Click on Merge button using Xpath Locator
	 * 	 * 12. Accept the Alert
	 * 	 * 13. Verify the title of the page
	 */
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	Launch URL
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	
//	Enter UserName and Password
	WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("DemoSalesmanager");
	
	WebElement pwd=driver.findElement(By.id("password"));
	pwd.sendKeys("crmsfa");
	
//	click on Login Button
	
	driver.findElement(By.className("decorativeSubmit")).click();

//	Click on CRM/SFA Link
	driver.findElement(By.xpath("//div[@for = 'crmsfa']")).click();

//	Click on contacts Button	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	
//	Click on Merge Contacts
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	
//	Click on Widget of From Contact
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
	
//  Click on First Resulting Contact
	
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> listwindow=new ArrayList<String>(windowHandles);
	driver.switchTo().window(listwindow.get(1));
	
//	Click on First Resulting Contact
	driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner')]/a)[1]")).click();
	
//	Click on Widget of To Contact
	driver.switchTo().window(listwindow.get(0));
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Thread.sleep(3000);
	
//	Click on Second Resulting Contact
	Set<String> windowHandles2 = driver.getWindowHandles();
	List<String> listwindow2=new ArrayList<String>(windowHandles2);
	driver.switchTo().window(listwindow2.get(1));
	
	driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();

//	Click on Merge button
	driver.switchTo().window(listwindow2.get(0));
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	
	System.out.println("clicked on merge button successfully" );
	
//	Accept the Alert
	Alert alert = driver.switchTo().alert();
	alert.accept();

//	Verify the title of the page
	
	String titleName = driver.getTitle();
	System.out.println("The title of the page is " + titleName);

	if (titleName.contains("View Contact"))
		System.out.println("Control is in the expected window");
	else
		System.out.println("Control is in the wrong window");
	
	driver.close();
	
	
	
	
	
	
	
	
}
	
	
}
