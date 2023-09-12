package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class FinishPage extends TestBase{
	
	@FindBy(xpath="//span[text()='Checkout: Complete!']") private WebElement checkoutCompleteLabel;
	@FindBy(xpath="//button[text()='Back Home']") private WebElement backHomeButton;
	@FindBy(xpath="//div[@id='checkout_complete_container']") private WebElement thankYouMessage;
	
	public FinishPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyCheckoutCompleteLabel()
	{
		return checkoutCompleteLabel.isDisplayed();
	}
	public boolean verifyBackHomeButton()
	{
		return backHomeButton.isDisplayed();
	}
	public String verifyThankYouMessage()
	{
		return thankYouMessage.getText();
	}
}
