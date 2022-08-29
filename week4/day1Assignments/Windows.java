package week4.day1Assignments;

import java.time.Duration;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("https://leafground.com/window.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	
	
//	To Click and Confirm new Window Opens
	String title = driver.getTitle();
	System.out.println("The title of the current tab is : " + title );
	
	driver.findElement(By.xpath("//span[text()='Open']/parent::button")).click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	List<String>windowNewList= new ArrayList<String>(windowHandles);
	driver.switchTo().window(windowNewList.get(1));
	String title1 = driver.getTitle();
	System.out.println("The title of the newly opened tab is : " + title1 );
	
	int totalNoOfWindows = windowNewList.size();
	System.out.println("The total number of tabs or windows that is open currently is : " + totalNoOfWindows);
	driver.close();
	
//	Find the number of opened tabs
	driver.switchTo().window(windowNewList.get(0));
	
	driver.findElement(By.xpath("//span[text() = 'Open Multiple']/parent::button")).click();
	
	Set<String> windowMul = driver.getWindowHandles();
	List<String> mulWindow= new ArrayList<String>(windowMul);
	int noOfOpenWindows = mulWindow.size();
	System.out.println("The total no of windows active after clicking the open multiple button = " + noOfOpenWindows);
	
	System.out.println("The reference code for the windows : " + mulWindow);

	//to close all the active windows
	for(int i=1;i<mulWindow.size();i++)
	{
		driver.switchTo().window(mulWindow.get(i));
		driver.close();
	}
	
	
	//	Close all windows except Primary	
	
	driver.switchTo().window(mulWindow.get(0));
	driver.findElement(By.xpath("//span[text() = 'Close Windows']/parent::button")).click();
	
   Set<String> closeWindowhandles = driver.getWindowHandles();
   List<String> closeWindow = new ArrayList<String>(closeWindowhandles);
   
   for(int i=1;i<closeWindow.size();i++)
	{
		driver.switchTo().window(closeWindow.get(i));
		driver.close();
	}
	
   
   
 //Wait for 2 new tabs to open
   
   driver.switchTo().window(closeWindow.get(0));
   
   driver.findElement(By.xpath("//span[text() = 'Open with delay']/parent::button")).click();
   Thread.sleep(3000);
   
   System.out.println("successfully clicked on Open with Delay button.");
   Set<String> delayWindowhandles = driver.getWindowHandles();
   List<String> delayWindow = new ArrayList<String>(delayWindowhandles);
   int countOfOpenWindows = delayWindow.size();
   System.out.println("The count of open tabs after clicking on 'open with delay' button is " + countOfOpenWindows );
   		 
   
   for(int i=1;i<delayWindow.size();i++)
	{
		driver.switchTo().window(delayWindow.get(i));
		driver.close();
	}
	
   driver.switchTo().window(delayWindow.get(0));
   
   
}
}
