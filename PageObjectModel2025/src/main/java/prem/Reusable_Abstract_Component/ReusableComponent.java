package prem.Reusable_Abstract_Component;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponent {
	WebDriver driver;
	public ReusableComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		

	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated((findBy)));
	}
	
	public void waitForElementToDisApper(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf((ele)));
		}		
	
}
