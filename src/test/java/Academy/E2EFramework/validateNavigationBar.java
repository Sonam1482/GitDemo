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


public class validateNavigationBar extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
	}

	@Test
	public void validateAppNavBar() throws IOException
	{
		
		//1. Inheritance
		// creating object to that class and invoke methods of it
		
		LandingPage l = new LandingPage(driver);
		//Compare the text from the browser with actual text
		Assert.assertTrue(l.getNavBar().isDisplayed());
		System.out.println("Test completed");
		log.info("Navigationbar is displayed");
		
		
		
	}
	@AfterTest
	public void tearDown()
	{
		 driver.quit();		
		 driver=null;
	}
	
	
}
