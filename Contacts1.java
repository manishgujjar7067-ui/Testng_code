package CRM_Project;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.java_utility;

public class Contacts1 extends BaseClass {

	@Test
	public void createConatctTest() throws IOException, ParseException, InterruptedException {

		// Java Utility
		int randomNum = java_utility.getrandomnumber();

		// Read data from Excel
		FileUtility futil = new FileUtility();
		String lastname = futil.getdatafromexcelfile("Contacts", 1, 0) + randomNum;
		String leadsource = futil.getdatafromexcelfile("Contacts", 1, 1);
		String email = futil.getdatafromexcelfile("Contacts", 1, 2);
		String assistant = futil.getdatafromexcelfile("Contacts", 1, 3);

//		open the browser

//		login 

//		create contact
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

//		fill the form
		driver.findElement(By.name("firstname")).sendKeys("Manish");
		driver.findElement(By.name("lastname")).sendKeys(lastname);

		WebElement LS = driver.findElement(By.name("leadsource"));
		Select sel = new Select(LS);
		sel.selectByVisibleText(leadsource);

		driver.findElement(By.id("email")).sendKeys(email);

		driver.findElement(By.id("assistant")).sendKeys(assistant);

//		save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//		verify

//		logout

//		close the browser

	}
}

