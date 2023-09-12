package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement verifyYourCartLabel;
	@FindBy(xpath="//button[@id='checkout']") private WebElement verifyCheckOutBtn;
	@FindBy(xpath="//div[@class='cart_list']") private WebElement verifyCartItems;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyUrlOfCartPage()
	{
		return driver.getCurrentUrl();
	}
	public boolean verifyYourCartLabel()
	{
		return verifyYourCartLabel.isDisplayed();
	}
	public boolean verifyCheckOutBtn()
	{
		return verifyCheckOutBtn.isDisplayed();
	}
	public String verifyCartItems()
	{
		return verifyCartItems.getText();
	}
	public void checkoutPageOpen()
	{
		verifyCheckOutBtn.click();
	}

}
