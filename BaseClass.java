package week6.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ChromeDriver driver;
	WebDriverWait wait;
	@BeforeMethod(alwaysRun = true, enabled = true, groups = "Leaftaps")
	public void preCondition() {
		//We have to call WDM for the browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser (chrome)
		driver = new ChromeDriver();

		//Load the URL
		driver.get("http://leaftaps.com/opentaps");

		//Maximize the browser
		driver.manage().window().maximize();

		//Find the user name and enter the username value(demosalesmanager)
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//Find the Password and enter the password value(crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click the Login Button
		driver.findElement(By.className("decorativeSubmit")).click();
		System.out.println("Login Successful");

		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//Wait 
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Timeouts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterMethod(alwaysRun = true, enabled = true, groups = "Leaftaps")
	public void postCondition() {
		driver.quit();
	}
}