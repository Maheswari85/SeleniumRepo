package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAlerts {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[text()='Browser']/ancestor::a")).click();
        driver.findElement(By.xpath("//span[text()='Alert']/ancestor::a")).click();
		
		driver.findElement(By.xpath("//button[@class = 'ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-success']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Harshad");
		alert.accept();
		
		driver.findElement(By.xpath("//button[@class = 'ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-button-danger']")).click();
		driver.findElement(By.xpath("//span[@class = 'ui-confirm-dialog-message']"));
		
		driver.findElement(By.xpath("//button[@class = 'ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-confirmdialog-yes']")).click();
		
		
		
	}
	
	
}
