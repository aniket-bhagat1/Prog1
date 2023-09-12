package Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;
import Utility.UtilityMethod;

public class ProductPage extends TestBase{

	@FindBy(xpath="//span[text()='Products']") private WebElement productLabel;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement swagLabLabel;
	@FindBy(xpath="//button[text()='Add to cart']") private WebElement addToCardBtn;
	@FindBy(xpath= "//span[@class='shopping_cart_badge']") private WebElement verifyProductAddedToCart;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement cartBtn;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement sortDropdown;
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyTitleOfProductPage()
	{
		return driver.getTitle();
	}
	public String verifyUrlOfProductPage()
	{
		return driver.getCurrentUrl();
	}
	public boolean verifyProductPageLabel()
	{
		return productLabel.isDisplayed();
	}
	public boolean verifySwagLabLabel()
	{
		return swagLabLabel.isDisplayed();
	}
	public void verifyAddToCartBtn() throws Exception
	{ 	UtilityMethod.selectClass(sortDropdown, "Price (high to low)");
	
		
		Thread.sleep(1000);
		for(int i=0;i<=5;i++)
		{
			addToCardBtn.click();
			Thread.sleep(1000);
		}
	}
	
	public String verifyProductAddedToCart()
	{
		return verifyProductAddedToCart.getText();
	}
	public void cartBtn()
	{
		cartBtn.click();
	}
}
