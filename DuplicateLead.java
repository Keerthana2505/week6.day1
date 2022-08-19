package week6.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead extends BaseClass {
	@Test(priority = 2,groups = "Leaftaps")
	public void dupLead() {

		//Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		// Type the first name
		driver.findElement(By.xpath("(//label[text()='First name:'])[3]/following::input")).sendKeys("Keerthu");
		// Click Find Leads Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// Click First Resulting Lead
		
		boolean staleElement = true; 

		while(staleElement){

			try{
				driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
				staleElement = false;


			} catch(StaleElementReferenceException e){

				staleElement = true;

			}

		}

		//Click on Duplicate button
		driver.findElement(By.linkText("Duplicate Lead")).click();

		//Clear the CompanyName Field using .clear() And Enter new CompanyName
		WebElement m = driver.findElement(By.id("createLeadForm_companyName"));
		m.clear();
		m.sendKeys("SRM Tech");

		//Clear the FirstName Field using .clear() And Enter new FirstName
		WebElement n = driver.findElement(By.id("createLeadForm_firstName"));
		n.clear();
		n.sendKeys("Keerthana");

		//Click on Create Lead Button
		driver.findElement(By.className("smallSubmit")).click();

		System.out.println("Lead Duplicated Successfully");
	}


	@Test(priority = 1, timeOut = 8000, invocationCount = 1,groups = "Leaftaps")
	public void createLead() {

		//Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();

		//Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();

		//Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		//Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Keerthu");

		//Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("J");

		//Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Keetz");

		//Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automation Testing");

		//Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium is a free (open-source) automated testing framework.");

		//Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("keerthanaj25@gmail.com");

		//Select State/Province as NewYork Using Visible Text
		WebElement dropdown1=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select = new Select(dropdown1);
		select.selectByVisibleText("New York");

		//Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Lead Created Successfully");
	}
}