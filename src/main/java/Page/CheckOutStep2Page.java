package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class CheckOutStep2Page extends TestBase {
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement checkOutOverviewLabel;
	@FindBy(xpath="//div[@class=\"summary_info\"]") private WebElement summary;
	@FindBy(xpath="//button[@id=\"finish\"]") private WebElement finishButton;
	public CheckOutStep2Page() 
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheckOutStep2PageUrl()
	{
		return driver.getCurrentUrl();
	}
	public boolean verifyCheckOutOverviewLabel()
	{
		return checkOutOverviewLabel.isDisplayed();
	}
	public String verifySummary()
	{
		return summary.getText();
	}
	public void finishPageMethod()
	{
		finishButton.click();
	}

}
