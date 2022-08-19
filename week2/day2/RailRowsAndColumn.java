package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RailRowsAndColumn {
public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://erail.in/");
driver.manage().window().maximize();

WebElement elementFrom = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
elementFrom.clear();
elementFrom.sendKeys("ms",Keys.TAB);

WebElement elementTo = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
elementTo.clear();
elementTo.sendKeys("pdy",Keys.TAB);

WebElement elementSortOnDate = driver.findElement(By.xpath("//input[@title='View trains running on select date']"));
elementSortOnDate.click();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

List<WebElement> elementsRows = driver.findElements(By.xpath("(//table)[3]/tbody/tr"));
// List<WebElement> elementsColumns = driver.findElements(By.xpath("(//table)[3]/tbody/tr/td"));

for (int i =1; i <= elementsRows.size();i++){
for (int j =1;j <=9;j++)

{
String text = driver.findElement
(By.xpath("(//table)[3]/tbody/tr["+i+"]/td["+j+"]")).getText();
System.out.print(text + "    ");
}
   System.out.println();



}
}
}



//}

