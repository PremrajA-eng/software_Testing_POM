package prem.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prem.pageobjects.CartPage;
import prem.pageobjects.CheckOutPage;
import prem.pageobjects.ConfirmationPage;
import prem.pageobjects.LandingPage;
import prem.pageobjects.ProductCatloguePage;
public class Login extends BaseTest {

//public static void main(String[] args) throws InterruptedException {
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
	 
		String productName="IPHONE 13 PRO";
		 String countryName = "India";
		 
	 LandingPage landingpage= launchApplication();
	ProductCatloguePage productcatlog=landingpage.loginApplication("arupremraj@gmail.com", "Prem@2625");
	Thread.sleep(3000);
  		List<WebElement>products =productcatlog.getProductList();
	    	     
      productcatlog.addProductToCart(productName);
	Thread.sleep(3000);
	CartPage cartPage=productcatlog.goToCartPage(); 
	 	 
     Boolean match= cartPage.VerifyProdutDisplay(productName);	
	  Assert.assertTrue(match);
	  
	  CheckOutPage chkout=cartPage.gotoCheckOut();
	  chkout.selectCountry(countryName); 
	  ConfirmationPage confpage=  chkout.submitOrder();
	String confMessage=  confpage.confirmmsg();
	Assert.assertTrue(confMessage.equalsIgnoreCase("Thankyou for the order."));
	driver.close();
}
}