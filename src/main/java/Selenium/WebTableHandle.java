package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableHandle {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://money.rediff.com/indices");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		List<WebElement> tableEle = driver.findElements(By.xpath("//tbody//tr"));
		for(int i=0;i<tableEle.size();i++)
		{
			System.out.println(tableEle.get(i).getText());
		}
		driver.quit();
		
		
	}

}
