package prem.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = ".cartSection h3")
   List<WebElement> cartProduct;	
  
	@FindBy (xpath = "//button[normalize-space()='Checkout']")
	WebElement checkoutele;
	
	
	
	public Boolean VerifyProdutDisplay(String productName) {
	Boolean match = cartProduct.stream().anyMatch(cartpro -> cartpro.getText().equalsIgnoreCase("IPHONE 13 PRO"));
	//Assert.assertTrue(match);
	return match;
	}
	
	public CheckOutPage gotoCheckOut() {
		checkoutele.click();
		CheckOutPage chkout=new CheckOutPage(driver);
		return chkout;
		
		
	}
}
