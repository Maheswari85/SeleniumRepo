package mStepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class BaseClass {
	 ChromeDriver driver;
	Shadow shadow;
	
	
@Given("Launch ServiceNow application with url as {string}")
public void LaunchWebsite(String url) {
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	driver.get(url); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	
@And("Login username as {string}") 
public void username(String username) {
	driver.findElement(By.id("user_name")).sendKeys(username);	
}
		
@And("Enter password as {string}")
public void password(String password) {
driver.findElement(By.id("user_password")).sendKeys(password);
driver.findElement(By.id("sysverb_login")).click();
}
@And("Click All")
public void clickall() {
	shadow = new Shadow(driver);
	shadow.setImplicitWait(10);
	shadow.findElementByXPath("//div[text()='All']").click();
}
@And("Click Incidents in Filter navigator")
public void filter() {
	shadow.findElementByXPath("//span[text()='Incidents']").click();
}
@And("Close the browser")
public void closeBrowser() {
	driver.close();	
}


}
