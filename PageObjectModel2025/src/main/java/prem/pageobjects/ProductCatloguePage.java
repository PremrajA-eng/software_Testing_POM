package prem.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prem.Reusable_Abstract_Component.ReusableComponent;

public class ProductCatloguePage extends ReusableComponent {

	WebDriver driver;

	public ProductCatloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // this is for initialize page factory webElements
	}

	// WebDriver userEmail= driver.findElement(By.id("userEmail"));
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By products1 = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".w-10:last-of-type");
	By tostmsg = By.cssSelector("#toast-container");
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		@FindBy (css = "[routerlink*='cart')")
	    WebElement cartHeder;

	public List<WebElement> getProductList() {
		waitForElementToAppear(products1);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("IPHONE 13 PRO"))
				.findFirst().orElse(null);
		return prod;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(tostmsg);
		waitForElementToDisApper(spinner);
	}
	public CartPage goToCartPage() {
		cartHeder.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}

}
