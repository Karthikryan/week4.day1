package Week4.day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mergeleads {

	public static void main(String[] args) throws InterruptedException,IOException  {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		Thread.sleep(5000);

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		String primary = driver.getWindowHandle();

		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();

		driver.findElement(By.linkText("Merge Leads")).click();

		driver.findElement(By.xpath("//span[text()='From Lead']/following::img")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);

		driver.switchTo().window(lstWindowHandles.get(1));

		driver.findElement(By.name("firstName")).sendKeys("Babu");

		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

		driver.switchTo().window(primary);

		System.out.println(driver.getTitle());



	}

}

