package Academy.E2EFramework;


import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


public class HomePage extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
			
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName, String Password, String Text) throws IOException
	{
		
		//1. Inheritance
		// creating object to that class and invoke methods of it
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click(); //driver.findElement(By.css)
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(Password);
		System.out.println(Text);
		System.out.println("sonam");
		System.out.println("sonam123");
		log.info(Text);
		lp.getLogin().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		 driver.quit();
		 driver=null;
	}
	//Parameterizing the data  
	
	@DataProvider
	public Object[][] getData()
	{
		//Rows stand for how many different data types test should run
		//cloumns stand for how many values per each test
		//Object[][] data = new Object[1][2];
		Object[][] data = new Object[2][3];
		data[0][0] ="nonrestricteduser@gmail.com";
		data[0][1]="123456";
		data[0][2]= "Resrticted User";
		
		data[1][0] ="restricteduser@gmail.com";
		data[1][1]="3456789";
		data[1][2]= "Non Resrticted User";
		
		return data;
	}
	
}
