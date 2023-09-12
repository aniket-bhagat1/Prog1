package TestClass;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Page.LoginPage;
import Utility.UtilityMethod;
import dev.failsafe.internal.util.Assert;

public class LoginPageTest extends TestBase{
	
	LoginPage login;
	@BeforeMethod(alwaysRun=true)
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
	}
	
	@Test(enabled = true, groups= {"loginPage","Sanity"})
	public void LoginToAppTest() throws Exception
	{
		String actRes = login.loginToApp();
		Thread.sleep(2000);
		String expRes = "https://www.saucedemo.com/inventorym.html";
		assertEquals(actRes, expRes);
		Reporter.log("Url of the inventory Page : " + actRes);
	}
	@Test(enabled=false, groups= {"loginPage","Sanity"})
	public void LoginPageUrlVeriTest()
	{
		String actRes = login.LoginPageUrlVeri();
		String expRes = "https://www.saucedemo.com/";
		org.testng.Assert.assertEquals(actRes, expRes);
		Reporter.log("Url of the Login Page : " + actRes);
	}
	@Test(enabled=false, groups="loginPage")
	public void verifyLoginPageTitle()
	{
		String actRes = login.verifyLoginPageTitle();
		String expRes = "Swag Labs";
		org.testng.Assert.assertEquals(actRes, expRes);
		Reporter.log("Title of the Login Page : " + actRes);
	}

	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult a) throws Exception
	{
		if(ITestResult.FAILURE==a.getStatus())
		{
			System.out.println("Method start");
			System.out.println(a.getStatus());
			System.out.println(ITestResult.FAILURE);
			UtilityMethod.captureScreenshot(a.getName());
			System.out.println("Method end");

		}
		driver.quit();
	}


}
