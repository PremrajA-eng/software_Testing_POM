package prem.pageobjects;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;

import prem.Reusable_Abstract_Component.ReusableComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Login {

public static void main(String[] args) throws InterruptedException {
	 String productName="IPHONE 13 PRO";
	 String countryName = "India";
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//************************************************************************
	//driver.get("https://rahulshettyacademy.com/client/");		
	//driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("arupremraj@gmail.com");
	//driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Prem@2625");
	//driver.findElement(By.xpath("//input[@id='login']")).click();	
	LandingPage landingpage=new LandingPage(driver); 
	landingpage.OpenUrl();
	ProductCatloguePage productcatlog=landingpage.loginApplication("arupremraj@gmail.com", "Prem@2625");
	Thread.sleep(3000);
  	//************************************************************************	
   //  List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	// ProductCatloguePage productcatlog= new ProductCatloguePage(driver);
	List<WebElement>products =productcatlog.getProductList();
	    	     
/*	WebElement prod = products.stream()
			.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("IPHONE 13 PRO"))
			.findFirst().orElse(null); */
	
		// prod.findElement(By.cssSelector(".w-10:last-of-type")).click();
      
      productcatlog.addProductToCart(productName);
      
      
             
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

	Thread.sleep(3000);
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); 
	//driver.findElement(By.xpath("//body//app-root//app-sidebar//li[4]")).click();
	CartPage cartPage=productcatlog.goToCartPage(); 
	 	 
     Boolean match= cartPage.VerifyProdutDisplay(productName);
	//Boolean match = cartproduct.stream().anyMatch(cartpro -> cartpro.getText().equalsIgnoreCase("IPHONE 13 PRO"));
	  Assert.assertTrue(match);
	  
	  CheckOutPage chkout=cartPage.gotoCheckOut();
	  chkout.selectCountry(countryName); 
	  ConfirmationPage confpage=  chkout.submitOrder();
	String confMessage=  confpage.confirmmsg();
	//driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

	//Actions a = new Actions(driver);
	//a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
//	Thread.sleep(3000);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ta-results")));
//	driver.findElement(By.xpath("//body//app-root//button[2]")).click();

//	driver.findElement(By.xpath("//a[normalize-space()='Place Order']")).click();

	//String result = driver.findElement(By.xpath("//h1[normalize-space()='Thankyou for the order.']")).getText();
	Assert.assertTrue(confMessage.equalsIgnoreCase("Thankyou for the order."));
	driver.close();
}
}