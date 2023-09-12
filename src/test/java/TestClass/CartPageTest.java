package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Page.CartPage;
import Page.LoginPage;
import Page.ProductPage;

public class CartPageTest extends TestBase{
	
	LoginPage login;
	ProductPage product;
	CartPage cart;
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		product= new ProductPage();
		cart= new CartPage();
		login.loginToApp();
		product.cartBtn();
	}
	@Test
	public void verifyUrlOfCartPageTest() 
	{
		String actRes = cart.verifyUrlOfCartPage();
		String expRes = "https://www.saucedemo.com/cart.html";
		Assert.assertEquals(actRes, expRes);
	}
	@Test
	public void verifyYourCartLabelTest() 
	{
		boolean actRes = cart.verifyYourCartLabel();
		Assert.assertEquals(actRes, true);
	}
	@Test
	public void verifyCheckOutBtnTest()
	{
		boolean actRes = cart.verifyCheckOutBtn();
		Assert.assertEquals(actRes, true);
	}
	@Test
	public void verifyCartItemsTest()
	{
		String actRes = cart.verifyCartItems();
		System.out.println(actRes);
	}
	@AfterMethod
	public void closeBrowser() 
	{
		driver.quit();
	}

}
