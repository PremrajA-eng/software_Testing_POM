package prem.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import prem.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties(); // read properties file
		FileInputStream fis= new FileInputStream(System.getProperty(System.getProperty("user.dir")+"C:\\Users\\admin\\eclipse-workspace\\PageObjectModel2025\\src\\test\\resources\\GlobalData.properties"));
		//C:\Users\admin\eclipse-workspace\PageObjectModel2025\src\test\resources\GlobalData.properties
		prop.load(fis);
		String browserName=prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		
		}
		
		else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	public LandingPage launchApplication() throws IOException {
		driver= initializeDriver();
		LandingPage landingpage=new LandingPage(driver); 
		landingpage.OpenUrl();
		return landingpage;
	}

}
