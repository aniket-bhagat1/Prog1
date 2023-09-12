package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggetion {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("seleni");
		Thread.sleep(2000);
		List<WebElement> suggetions = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(int i=0;i<suggetions.size();i++)
		{
			System.out.println(suggetions.get(i).getText());
		}
		for(int i=0;i<suggetions.size();i++)
		{
			if(suggetions.get(i).getText().equals("selenium webdriver download"));
			suggetions.get(i).click();break;
		}
		driver.quit();
	}

}
