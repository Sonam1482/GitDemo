package Academy.E2EFramework;


import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



import pageObjects.LandingPage;

import resources.Base;


public class validateTitle extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
//		if(driver==null)
//		{
//			System.out.println("Yes null for validation");
//		}
//		else {
//			System.out.println("Not null for validation");
//		}
		driver= initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to HomePage");
	}
	
	@Test
	public void validateAppTitle() throws IOException
	{
		
		//1. Inheritance
		// creating object to that class and invoke methods of it		
		LandingPage l = new LandingPage(driver);
		//Compare the text from the browser with actual text
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		System.out.println("Test completed");
		log.info("Successfully validated Text message");
				
	}
	@AfterTest
	public void tearDown()
	{
		 driver.quit();
		 driver=null;
	}
	
	
}
