package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOnInputFields {
	
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("https://www.leafground.com/input.xhtml");
	driver.manage().window().maximize();
	
//	to type name in the 'Type your name' field
	WebElement typeName = driver.findElement(By.xpath("//input[@placeholder = 'Babu Manickam']"));
	typeName.sendKeys("Harshad");
	
//	to Append Country to this City.
	
	WebElement appendCountry = driver.findElement(By.xpath("//input[@value = 'Chennai']"));
	appendCountry.sendKeys(" India");
	
//	To find whether the field is disabled
	
	WebElement fieldDisabled = driver.findElement(By.xpath("//input[@placeholder = 'Disabled']"));
	Boolean valueOffieldDisabled = fieldDisabled.isEnabled();
	
	if (valueOffieldDisabled == true) {
		System.out.println("The Field is enabled");
	}
	else {
		System.out.println("I confirm the field is disabled");
	}
	
//	to clear the field
	WebElement clearField = driver.findElement(By.xpath("//input[@value = 'Can you clear me, please?']"));
	String fieldValue = clearField.getAttribute("Value");
	System.out.println("The value in the field is " + fieldValue );
	
	clearField.clear();
	String newFieldValue = clearField.getText();
	System.out.println("The value of the field after clearing is "+ newFieldValue);
	if (newFieldValue.equals(" ")) {
		System.out.println("The field has been cleared successfully");
	}
	else {
		System.out.println("The field value has not been cleared.");
	}
	
	
	
//	to get the value of the field
	WebElement ValueOfTheField = driver.findElement(By.xpath("(//input[@role = 'textbox'])[5]"));
	String value1 = ValueOfTheField.getAttribute("value");
	System.out.println("The retrived typed text from the field is "+ value1);
	

//	
//	to type email and confirm if the control has moved to the next field after giving Tab
	WebElement emailField = driver.findElement(By.xpath("//input[@placeholder= 'Your email and tab']"));
	emailField.sendKeys("Test123@gmail.com",Keys.TAB);
	
//	to type text in the text editor
	WebElement textEditor = driver.findElement(By.xpath("(//div[@class= 'ql-editor ql-blank'])[1]"));
	textEditor.sendKeys("I am Learning Selenium in TestLeaf");
String textValueInEditor = textEditor.getText();
System.out.println("The entered text in the editor is : "+ textValueInEditor );

//to press enter in the field and verify if the field throws error message

WebElement pressEnter = driver.findElement(By.xpath("(//input[@role='textbox'])[7]"));
pressEnter.click();
pressEnter.sendKeys (Keys.ENTER);

Boolean alert = driver.findElement(By.xpath("//div[@role ='alert']")).isDisplayed();
System.out.println(alert);
if (alert = true) {
	System.out.println("The alert pop up is displayed");
}
else {
	System.out.println("The alert pop up is not displayed");
}











}






}
