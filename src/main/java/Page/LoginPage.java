package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement password;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;

	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginToApp() throws Exception
		{
			Thread.sleep(2000);
			username.sendKeys(ReadData.readPropertyFile("username"));
//			username.sendKeys(ReadData.readExcelFile(0, 0));
			Thread.sleep(2000);
			password.sendKeys(ReadData.readPropertyFile("password"));
//			password.sendKeys(ReadData.readExcelFile(0, 1));
			Thread.sleep(2000);
			loginBtn.click();
			Thread.sleep(2000);
			return driver.getCurrentUrl();
		}
	
		public String LoginPageUrlVeri()
		{
			return driver.getCurrentUrl();
		}
		
	
	    public String verifyLoginPageTitle()
	    {
	    	return driver.getTitle();
	    }
	    
	

}

