package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Page.CartPage;
import Page.CheckOutPage;
import Page.CheckOutStep2Page;
import Page.LoginPage;
import Page.ProductPage;

public class CheckOutPage2Test extends TestBase {
	
	LoginPage login;
	ProductPage product;
	CartPage cart;
	CheckOutPage check1;
	CheckOutStep2Page check2;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login=new LoginPage();
		product=new ProductPage();
		cart=new CartPage();
		check1=new CheckOutPage();
		check2=new CheckOutStep2Page();
		login.loginToApp();
		Thread.sleep(1000);
		product.cartBtn();
		Thread.sleep(1000);
		cart.checkoutPageOpen();
		Thread.sleep(1000);
		check1.verifyYourDetails();
		Thread.sleep(1000);
		
		
	}
	
	@Test
	public void verifyCheckOutStep2PageUrlTest()
	{
		String actRes = check2.verifyCheckOutStep2PageUrl();
		String expRes ="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(actRes, expRes);
	}
	
	@Test
	public void verifyCheckOutOverviewLabelTest()
	{
		 boolean actRes = check2.verifyCheckOutOverviewLabel();
		Assert.assertEquals(actRes, true);
	}
	@Test
	public void verifySummaryTest()
	{
		 String actRes = check2.verifySummary();
		System.out.println(actRes);
	}
	@Test
	public void finishPageTest()
	{
		check2.finishPageMethod();
		String actualRes = driver.getCurrentUrl();
		String expRes = "https://www.saucedemo.com/checkout-complete.html";
		Assert.assertEquals(actualRes, expRes);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	

}
