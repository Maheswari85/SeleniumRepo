package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOnCheckBox {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize(); 
		
		WebElement checkBox = driver.findElement(By.xpath("//span[text () = 'Basic']"));
		checkBox.click();
		
		WebElement AjaxBox = driver.findElement(By.xpath("//span[text () = 'Ajax']"));
		AjaxBox.click();
		
		
		
		WebElement favLang1 = driver.findElement(By.xpath("//label[text () = 'Java']"));
		favLang1.click();
		WebElement favLang2 = driver.findElement(By.xpath("//label[text () = 'Python']"));
		favLang2.click();
		WebElement favLang3 = driver.findElement(By.xpath("//label[text () = 'Others']"));
		favLang3.click();
		
		Thread.sleep(7000);
		Boolean isEnabled = driver.findElement(By.xpath("//input[@aria-disabled= 'true']")).isEnabled();
		if (isEnabled) {
			System.out.println("The field is enabled");	
		}
		else {
			System.out.println("The field is disabled");
		}
		
	Thread.sleep(2000);
		WebElement mulSelDdwn = driver.findElement(By.xpath("//ul[@data-label = 'Cities']"));
		mulSelDdwn.click();
		WebElement mulSelDdwn1 = driver.findElement(By.xpath("(//label[text() = 'London'])[2]"));
		mulSelDdwn1.click();
		WebElement mulSelDdwn2 = driver.findElement(By.xpath("(//label[text() = 'Miami'])[2]"));
		mulSelDdwn2.click();
		WebElement mulSelDdwn3 = driver.findElement(By.xpath("(//label[text() = 'Paris'])[2]"));
		mulSelDdwn3.click();
		
		WebElement closeDropdwn = driver.findElement(By.xpath("//span[@class = 'ui-icon ui-icon-circle-close']"));
		closeDropdwn.click();
		
	}
}
