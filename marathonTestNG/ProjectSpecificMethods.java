package marathonTestNG;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

//import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ProjectSpecificMethods {
	public RemoteWebDriver driver;
	public String excelFileName;
	public Shadow shadow;
	@Parameters({"url","browser"})
	
	
	@BeforeMethod (alwaysRun = true )
	public void preConditions(String url,String browser) {
		 
	//1. Launch ServiceNow application
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//2. Login with valid credentials username and password 
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Service@123");
		driver.findElement(By.id("sysverb_login")).click();
		
	//3. Click All
		shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[text()='All']").click();

	//4.Click  Incidents in Filter navigator
		shadow.findElementByXPath("//span[text()='Incidents']").click();
	
}

@AfterMethod (alwaysRun = true )
public void afterMethod() {
	driver.close();
}

@DataProvider()
public String [][] sendData() throws IOException{
	String[][] data = ReadExcelData.getdata(excelFileName);
	return data;
	
	
}

}