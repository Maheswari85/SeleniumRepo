package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://jqueryui.com/draggable/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement frm = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frm);
	WebElement drag = driver.findElement(By.id("draggable"));
	Actions builder=new Actions(driver);
	builder.dragAndDropBy(drag, 75, 75).perform();
	
	
}
}
