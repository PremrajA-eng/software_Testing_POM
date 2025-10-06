package prem.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prem.Reusable_Abstract_Component.ReusableComponent;

public class LandingPage extends ReusableComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);  // this is for  initialize page factory webElements 
	}
	
	
	//WebDriver userEmail= driver.findElement(By.id("userEmail"));
    @FindBy(id="userEmail")
    WebElement userEmail;
    
    @FindBy(id="userPassword")
    WebElement userPassword;
    
    @FindBy(id="login")
    WebElement submit;
    
    public ProductCatloguePage loginApplication(String email,String password) {
    	userEmail.sendKeys(email);
    	userPassword.sendKeys(password);
    	submit.click();
    	ProductCatloguePage productcatlog= new ProductCatloguePage(driver);
    	return productcatlog;
    } 
    public void OpenUrl() {
    	driver.get("https://rahulshettyacademy.com/client/");
    	
    }
    
    
    
    
    
    
    
    
}
