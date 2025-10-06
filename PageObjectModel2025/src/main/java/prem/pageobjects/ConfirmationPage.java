package prem.pageobjects;

import java.awt.image.RescaleOp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import prem.Reusable_Abstract_Component.ReusableComponent;

public class ConfirmationPage extends ReusableComponent {
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath ="//h1[normalize-space()='Thankyou for the order.']")
    WebElement confMsg;
	
	public String confirmmsg() {
		return confMsg.getText();
	}
	
	
}
