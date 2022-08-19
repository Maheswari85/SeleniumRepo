package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentsOnLinks {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.leafground.com/link.xhtml");
	driver.manage().window().maximize(); 
	
//	to take me to dashboard
	WebElement dashBoardLink = driver.findElement(By.xpath("//a[@class='ui-link ui-widget']"));
	dashBoardLink.click();
	
//	to get the destination 
	driver.get("https://www.leafground.com/link.xhtml");
	WebElement findDestination = driver.findElement(By.xpath("(//a[@class='ui-link ui-widget'])[2]"));
	String linkValue = findDestination.getAttribute("href");
	System.out.println(linkValue);
	
// to find the no of links
	List<WebElement> findTheNoOfLinks = driver.findElements(By.xpath("(//a[@class = 'ui-link ui-widget'])[4]"));
	 int noOfLinks = findTheNoOfLinks.size();
	System.out.println("The no of Links in this page is "+noOfLinks);
	
	
	
	
}
	
	
}
