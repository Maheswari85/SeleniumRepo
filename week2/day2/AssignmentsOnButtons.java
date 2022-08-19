package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class AssignmentsOnButtons {

	private static WebElement findElement;

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

		
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
//		to confirm the title:
		WebElement clickButton = driver.findElement(By.xpath("//button[@role = 'button'][1]"));
		clickButton.click();
		String title = driver.getTitle();
		
		System.out.println("The Title of the page is : " + title);
		
		if (title.contains("Dashboard") ) {
			
			System.out.println("I confirm the title has Dashboard in it. ");
		}
		else {
			System.out.println("The Title does not contain Dashboard");
		}
		
//		to get the position of the button;
		
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
        Point positionOFSubmitBtn = driver.findElement(By.xpath("(//button)[3]")).getLocation();;
		System.out.println("The position of the Submit Button is "+ positionOFSubmitBtn);
	
		
//		to find whether the button is disabled
		 boolean stateOfButton = driver.findElement(By.xpath("(//button[@type='button'])[2]")).isEnabled();
         System.out.println(stateOfButton);
		if (stateOfButton == false) {
			System.out.println("The state of the button is disabled ");
			
		}
		else {
			System.out.println("The state of the button is enabled ");
		}
		
//		to find the save button color
			
	    String saveButtonColor = driver.findElement(By.xpath("(//button)[4]")).getCssValue("background-color");
		System.out.println("The colour of the save button is "+ saveButtonColor);
		
//		to find the height and width of Submit button
		 Dimension heightAndWidth = driver.findElement(By.xpath("(//button)[5]")).getSize();
		System.out.println("The Height and Width of the Submit button is "+ heightAndWidth);
		
//		to find the no of buttons
//		WebElement noOfButtons = driver.findElement(By.xpath("(//div[@class = 'card'])[7]"));
//		System.out.println("The total no of buttons in 'How many rounded buttons are there' section is "+ noOfButtons);
		}
		
}
