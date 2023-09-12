package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class CheckOutPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement verifyYourInfoLabel;
	@FindBy(xpath="//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath="//input[@id='last-name']") private WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement zipcode;
	@FindBy(xpath="//input[@id='continue']") private WebElement continueBtn;
	
	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheckoutStepOneUrl()
	{
		return driver.getCurrentUrl();
	}
	public boolean verifyYourInfoLabel()
	{
		return verifyYourInfoLabel.isDisplayed();
	}
	public void verifyYourDetails() throws Exception
	{
		Thread.sleep(1000);
		firstName.sendKeys("Aniket");
		Thread.sleep(1000);
		lastName.sendKeys("Bhagat");
		Thread.sleep(1000);
		zipcode.sendKeys("123432");
		Thread.sleep(1000);
		continueBtn.click();
		
	}
}
