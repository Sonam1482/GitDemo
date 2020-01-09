package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;


public class Base {

	public static WebDriver driver;
	public Properties prop;
		public WebDriver initializeDriver() throws IOException
		{
		 prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\Yogesh\\eclipse1\\E2EFramework\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
			
			 prop.getProperty("browser");
			 String browserName=prop.getProperty("browser");
			 System.out.println(browserName);

		
			
			 if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yogesh\\Downloads\\driver\\chromedriver.exe");
				 driver = new ChromeDriver();	
				
			}
			 if(browserName.equalsIgnoreCase("firefox"))
			{
				 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yogesh\\Downloads\\driver\\geckodriver.exe");
				 driver = new FirefoxDriver();	
				
			}
			 else if (browserName.equals("IE"))
			{
				 System.setProperty("webdriver.ie.driver", "C:\\Users\\Yogesh\\Downloads\\driver\\MicrosoftWebDriver.exe");
				 driver = new InternetExplorerDriver();	
			}

			 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			 return driver;
		}
		
		//screenshot
		public void getScreenshot(String result) throws IOException
		{
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//copy from virtual to local machine
			//static screenshot
			//FileHandler.copy(src, new File("C://test//screenshot.png"));
			//dynamic screenshot
			FileHandler.copy(src, new File("C://test//"+result+"screenshot.png"));
		}
}
