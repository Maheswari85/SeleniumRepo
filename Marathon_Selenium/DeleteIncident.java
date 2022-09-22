package marathon;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class DeleteIncident {
	public static void main(String[] args) throws InterruptedException {

		//1. Launch ServiceNow application
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev135016.service-now.com"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//2. Login with valid credentials username and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@123");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);

		//3. Click All
		Thread.sleep(8000);
		shadow.findElementByXPath("//div[text()='All']").click();

	    //4.Click  Incidents in Filter navigator
	   	shadow.findElementByXPath("//span[text()='Incidents']").click();
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);
		
		WebElement existingincident =driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']"));
		String exID = existingincident.getText();
		System.out.println("The incident ID selected for deletion is : " + exID);
		existingincident.click();

		//5. Delete the incident
		shadow.findElementByXPath("//button[text()='Delete']").click();
		
		driver.findElement(By.id("ok_button")).click();

		//6. Verify the deleted incident
		driver.findElement(By.xpath("//b[text() = 'All']")).click();
		WebElement srchDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(srchDD);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(exID,Keys.ENTER);
		
		
		String msg = driver.findElement(By.className("list2_empty-state-list")).getText();
		System.out.println(msg);
		
		if (msg.contains("No records to display")) {
			System.out.println("Incident Deleted Sucessfully.");
		}
		else {
			System.out.println("Incident Deletion unsucessful.");
		}
	}

}
