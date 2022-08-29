package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement myFrame = driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(myFrame);
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		
		Actions pointer = new Actions(driver);
		pointer.dragAndDrop(source, destination).perform();
		
		
}
}
