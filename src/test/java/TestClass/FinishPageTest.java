package TestClass;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Page.CartPage;
import Page.CheckOutPage;
import Page.CheckOutStep2Page;
import Page.FinishPage;
import Page.LoginPage;
import Page.ProductPage;
import Utility.UtilityMethod;

public class FinishPageTest extends TestBase {

	LoginPage login;
	ProductPage product;
	CartPage cart;
	CheckOutPage check1;
	CheckOutStep2Page check2;
	FinishPage finish;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login=new LoginPage();
		product=new ProductPage();
		cart=new CartPage();
		check1=new CheckOutPage();
		check2=new CheckOutStep2Page();
		finish= new FinishPage();
		login.loginToApp();
		Thread.sleep(1000);
		product.verifyAddToCartBtn();
		Thread.sleep(1000);
		product.cartBtn();
		Thread.sleep(1000);
		cart.checkoutPageOpen();
		Thread.sleep(1000);
		check1.verifyYourDetails();
		Thread.sleep(1000);
		check2.finishPageMethod();
		
		
	}
	
	@Test(enabled=false)
	public void verifyCheckoutCompleteLabelTest()
	{
		boolean actRes = finish.verifyCheckoutCompleteLabel();
		Assert.assertEquals(actRes, true);
	}
	
	@Test(enabled=true)
	public void verifyBackHomeButtonTest()
	{
		boolean actRes = finish.verifyBackHomeButton();
		Assert.assertEquals(actRes, false);
	}
	@Test(enabled=false)
	public void verifyThankYouMessage()
	{
		String actRes = finish.verifyThankYouMessage();
		System.out.println(actRes);
	}
	@AfterMethod
	public void closeBrowser(ITestResult a) throws Exception
	{ 	
		if(ITestResult.FAILURE == a.getStatus())
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
