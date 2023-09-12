package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Page.CartPage;
import Page.CheckOutPage;
import Page.LoginPage;
import Page.ProductPage;

public class CheckOutPageTest extends TestBase {

	LoginPage login;
	ProductPage product;
	CartPage cart;
	CheckOutPage check1;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login= new LoginPage();
		product=new ProductPage();
		cart= new CartPage();
		check1=new CheckOutPage();
		login.loginToApp();
		Thread.sleep(2000);
		product.cartBtn();
		Thread.sleep(2000);
		cart.checkoutPageOpen();
		Thread.sleep(2000);
	}
	@Test(enabled=true)
	public void verifyCheckoutStepOneUrlTest()
	{
		String actRes = check1.verifyCheckoutStepOneUrl();
		String expRes = "https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(actRes, expRes);
	}
	@Test(enabled=true)
	public void verifyYourInfoLabelTest()
	{
		boolean actRes = check1.verifyYourInfoLabel();
		Assert.assertEquals(actRes, true);
	}
	@Test(enabled=true)
	public void verifyYourDetailsTest() throws Exception
	{
		check1.verifyYourDetails();
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
