package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookAccountCreation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		WebElement elementEmailAddress = driver.findElement(By.xpath("//input[@id = 'email']"));
		elementEmailAddress.sendKeys("kannanharshad@gmail.com");
		
		WebElement elementAccountPassword = driver.findElement(By.xpath("//input[@type = 'password']"));
		elementAccountPassword.sendKeys("Testid@123");
		
		WebElement elementCreateNewAccount = driver.findElement(By.xpath("(//a[@role = 'button'])[2]"));
		elementCreateNewAccount.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement elementFirstName = driver.findElement(By.name("firstname"));
		elementFirstName.sendKeys("Harshad");
//		//input[@name='firstname']"));
		
		WebElement elementMobileNumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		elementMobileNumber.sendKeys("9988776655");
		
		WebElement elementNewPassword = driver.findElement(By.xpath("//input[@data-type='password']"));
		elementNewPassword.sendKeys("Mypswd@123");
		
		WebElement elementDOB = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select drpdwn1 = new Select(elementDOB);
		drpdwn1.selectByVisibleText("4");
		
		WebElement elementMonth = driver.findElement(By.xpath("//select[@title='Month']"));
		Select drpdwn2 = new Select(elementMonth);
		drpdwn2.selectByValue("12");
		
		WebElement elementYear = driver.findElement(By.xpath("//select[@title='Year']"));
		Select drpdwn3 = new Select(elementYear);
		drpdwn3.selectByValue("1985");
		
		WebElement elementFemaleRadioButton = driver.findElement(By.xpath("//input[@type='radio'][1]"));
		elementFemaleRadioButton.click();
		
		
		
		
		
		
		
		
		
		
		
	}
}