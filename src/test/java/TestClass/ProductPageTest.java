package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.TestBase;
import Page.LoginPage;
import Page.ProductPage;

public class ProductPageTest extends TestBase{
	LoginPage login;
	ProductPage product;
	@BeforeMethod (alwaysRun=true)
	public void setup() throws Exception
	{
		initialization();
		login = new LoginPage();
		product = new ProductPage();
		login.loginToApp();
	}
	@Test(enabled=false)
	public void verifyTitleOfProductPageTest() throws Exception
	{	
		String actRes = product.verifyTitleOfProductPage();
		String expRes = "Swag Labs";
		Assert.assertEquals(actRes, expRes);
	}
	@Test(enabled=false, groups="loginPage")
	public void verifyUrlOfProductPageTest() throws Exception
	{
		String actRes = product.verifyUrlOfProductPage();
		String expRes = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actRes, expRes);
	}
	@Test(enabled=false)
	public void verifySwagLabLabelTest() throws Exception
	{
		boolean actRes = product.verifySwagLabLabel();
		Assert.assertEquals(actRes, true);
		
	}
	@Test(enabled=false)
	public void verifyProductPageLabelTest() throws Exception
	{
		boolean actRes = product.verifyProductPageLabel();
		Assert.assertEquals(actRes, true);
	}
	@Test(enabled=false)
	public void verifyAddToCartBtnTest() throws Exception
	{
		product.verifyAddToCartBtn();
	}
	@Test
	public void verifyProductAddedToCartTest() throws Exception
	{    System.out.println("Method Started");
		 product.verifyAddToCartBtn();
		 String actRes = product.verifyProductAddedToCart();
		 String expRes = "4";
		 System.out.println("Products added to cart : " + actRes);
		 SoftAssert soft = new SoftAssert();
		 soft.assertEquals(actRes, expRes);
		 soft.assertAll();
		 System.out.println("Method End");

	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}

}
