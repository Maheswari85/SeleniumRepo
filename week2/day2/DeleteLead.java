package week2.day2;





	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.devtools.v94.browser.Browser;
	import org.openqa.selenium.support.ui.Select;
	import java.time.Duration;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import io.opentelemetry.exporter.logging.SystemOutLogExporter;

	
	public class DeleteLead {
		
			public static void main(String[] args) throws InterruptedException {
				
			
					WebDriverManager.chromedriver().setup();
					ChromeDriver driver = new ChromeDriver();
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
					driver.get("http://leaftaps.com/opentaps/control/main");
					driver.manage().window().maximize();
					
					WebElement elementUserName = driver.findElement(By.xpath("//input[@class = 'inputLogin']"));
					elementUserName.sendKeys("Demosalesmanager");
					
					WebElement elementPassword = driver.findElement(By.xpath("//input[@type = 'password']"));
					elementPassword.sendKeys("crmsfa");
					

					WebElement elementLogin = driver.findElement(By.xpath("//input[@type = 'submit']"));
					elementLogin.click();
					
					WebElement elementcrmsfa = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
					elementcrmsfa.click();
					
					WebElement elementLeads = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
					elementLeads.click();
					
					
					
					WebElement elementFindLeads = driver.findElement(By.xpath("//a[contains (text(),'Find Leads')]"));
					elementFindLeads.click();
					
					
					
					WebElement elementPhoneButton = driver.findElement(By.xpath("(//a[@class = 'x-tab-right'])[2]"));
					elementPhoneButton.click();
					
					
					
					WebElement elementPhoneNumber = driver.findElement(By.xpath("//input[@name = 'phoneNumber']"));
					elementPhoneNumber.sendKeys("98");
					
					WebElement elementFindLeadsButton = driver.findElement(By.xpath("(//td[@class = 'x-btn-center'])[7]"));
					elementFindLeadsButton.click();
					
					System.out.println("Pressed Find Lead Button Successfully");
					
					Thread.sleep(1000);	
					
					WebElement elementFirstValue= driver.findElement(By.xpath("(//div/a[@class = 'linktext'])[4]"));
					String leadId = elementFirstValue.getText();
					
					System.out.println("The Lead ID of the first resulting row is " + leadId );
					elementFirstValue.click();
					
					WebElement elementDeleteButton = driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']"));
					elementDeleteButton.click();
					
				
					WebElement elementFindLeadButton = driver.findElement(By.xpath("//a[@href='/crmsfa/control/findLeads']"));
					elementFindLeadButton.click();
					
					System.out.println("The find lead button pressed successfully");
					Thread.sleep(1000);
					
					WebElement elementToEnterLeadId = driver.findElement(By.xpath("//input[@name='id']"));
					elementToEnterLeadId.sendKeys(leadId);
					
					Thread.sleep(1000);
					
					WebElement elementToFindLead = driver.findElement(By.xpath("(//td[@class ='x-btn-center'] )[7]"));
					elementToFindLead.click();
					
					Thread.sleep(1000);
					WebElement elementLeadList = driver.findElement(By.xpath("//div[@class = 'x-paging-info']"));
					String message = elementLeadList.getText();
					
					System.out.println(message);
					
					if (message.contains("No records to display")) {
						
						System.out.println("It is confirmed that the Lead has been deleted sucessfully" ) ;
					}
					
					else {
						System.out.println("The Lead deletion is unsuccessful");
					}
					
//					driver.close();
					}
					
					
			}
	
					

