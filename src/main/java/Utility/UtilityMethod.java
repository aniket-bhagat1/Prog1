package Utility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseClass.TestBase;

public class UtilityMethod extends TestBase{
	
	public static void selectClass(WebElement element, String option)
	{
		Select s = new Select(element);
		s.selectByVisibleText(option);
	}
//	public static void captureScreenshot(String name) throws Exception 
//	{
//		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\Screenshots/"+name+".jpeg");
//		org.openqa.selenium.io.FileHandler.copy(source, dest);
//	}
	
	public static void captureScreenshot(String name) throws Exception
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\Screenshots/"+name+".jpeg");
		org.openqa.selenium.io.FileHandler.copy(source, dest);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
