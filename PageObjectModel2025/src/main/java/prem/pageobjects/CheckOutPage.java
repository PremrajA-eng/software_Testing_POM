package prem.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prem.Reusable_Abstract_Component.ReusableComponent;

public class CheckOutPage extends ReusableComponent {
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(css= "[placeholder='Select Country']")
    WebElement country;
    
    @FindBy(xpath = "//body//app-root//button[2]")
    WebElement selectIndia;
    
    
    @FindBy(css= ".action__submit")
    WebElement submit;
    
    By result=By.cssSelector("ta-results");
    
    public void selectCountry(String countryName) throws InterruptedException {
    	Actions a = new Actions(driver);
    	a.sendKeys(country, "countryName").build().perform(); 
    	Thread.sleep(3000);
    	//waitForElementToAppear(result);
    	selectIndia.click();
    }
    
    public ConfirmationPage submitOrder() {
    	
    	submit.click();
    	ConfirmationPage confpage= new ConfirmationPage(driver);
    	return  confpage;
    	
    }
    
}
