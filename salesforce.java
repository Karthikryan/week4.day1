package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class salesforce {

	public static void main(String[] args) throws InterruptedException {
		
		
	/*3.Assignment for WindowHandles  
	
		Salesforce Customer service:
		1.Launch the browser
		2.Load the url as " https://login.salesforce.com/ "
		3.Enter the username as " ramkumar.ramaiah@testleaf.com "
		4. Enter the password as " Password$123 "
		5.click on the login button
		6.click on the learn more option in the Mobile publisher
		7.Switch to the next window using Windowhandles.
		8.click on the confirm button in the redirecting page
		9.Get the title
		10.Get back to the parent window
		11.close the browser  */
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get(" https://login.salesforce.com/ ");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("password")).sendKeys ("Password$123");
		
		String primary = driver.getWindowHandle();
		
		driver.findElement(By.id("Login")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[text()='Mobile Publisher']/following::button[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();

		//Thread.sleep(5000);
		
		//click on the learn more option in the Mobile publisher
		
	
		
		
		//Switch to the next window using Windowhandles
		
		
		
		List<String> listwindowHandles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(listwindowHandles.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		driver.switchTo().window(primary);

		System.out.println(driver.getTitle());
		
		driver.quit();

		
				
		
	}

}
