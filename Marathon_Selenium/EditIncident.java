package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class EditIncident {
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
		shadow.findElementByXPath("//div[text()='All']").click();

		//4.Click  Incidents in Filter navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
		
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		driver.switchTo().frame(eleFrame);

		//4. Search for the existing incident and click on the incident
		WebElement existingincident =driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']"));
		String exID = existingincident.getText();
		existingincident.click();
		
		//5. Update the incident with Urgency as High and State as In Progress
		WebElement eleCallerID = driver.findElement(By.id("sys_display.incident.caller_id"));
		eleCallerID.clear();
		eleCallerID.sendKeys("abel",Keys.TAB);
		Thread.sleep(1000);
		
		WebElement urgency = driver.findElement(By.xpath("//select[@id ='incident.urgency']"));
		Select urgencyDD=new Select(urgency);
		urgencyDD.selectByVisibleText("1 - High");
		
		System.out.println("The urgency option selected is '1 - High'");
		
		WebElement status = driver.findElement(By.xpath("//select[@name = 'incident.state']"));
		Select statusDD=new Select(status);
		statusDD.selectByVisibleText("In Progress");
		
		System.out.println("The Status selected is 'In Progress'" );
		
		WebElement eleShortDesc = driver.findElement(By.id("incident.short_description"));
		eleShortDesc.clear();
		eleShortDesc.sendKeys("Edited Via Automation");
		
		System.out.println("Short Description entered is 'Edited via Automation'" );
		
		driver.findElement(By.xpath("//button[text()='Update']")).click();	
		
		//6. Verify the updated information is available in the incident
		
//		WebElement searchwin = shadow.findElementByXPath("//iframe[@title='Main Content']");
//		driver.switchTo().frame(searchwin);
		driver.findElement(By.xpath("//b[text() = 'All']")).click();
		WebElement srchDD = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(srchDD);
		numberDD.selectByVisibleText("Number");
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(exID,Keys.ENTER);
		

		String ConfmId = driver.findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		String descptn = driver.findElement(By.xpath("//td[@class ='vt'][3]")).getText();
		String state = driver.findElement(By.xpath("//td[@class ='vt'][5]")).getText();
		String urgncycode = driver.findElement(By.xpath("//td[@class ='vt'][6]")).getText();
		
		if (ConfmId.contains(exID)) {
			System.out.println("Id verified sucessfully.");
		}
		else {
			System.out.println("Id not matching.");
		}
		if (descptn.contains("Edited Via Automation")) {
			System.out.println("Short Description verified sucessfully.");
		}
		else {
			System.out.println("Description not matching");
		}
		if (state.contains("In Progress")) {
			System.out.println("Status verified sucessfully.");
		}
		else {
			System.out.println("Status not matching");
		}
		
		if (urgncycode.contains("1 - High")) {
			System.out.println("Urgency verified sucessfully.");
		}
		else {
			System.out.println("Urgency not matching");
		}
		driver.close();
	}
}
