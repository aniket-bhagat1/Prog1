package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReadData {
	
	public static String readExcelFile(int row,int col) throws Exception
	{
		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\TestData\\excelData.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(row).getCell(col).getStringCellValue();
		return value;
	}

	public static String readPropertyFile(String value) throws Exception
	{
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\TestData\\config.properties");
		p.load(file);
		return p.getProperty(value);
	
	}
//	
//	public static String readExcelFile(int row, int col) throws Exception
//	{
//		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\TestData\\excelData.xlsx");
//		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
//		String value = excel.getRow(row).getCell(col).getStringCellValue();
//		return value;
//		String pw = excel.getRow(0).getCell(1).getStringCellValue();
//		String url = excel.getRow(0).getCell(2).getStringCellValue();
//	}
	
//	public static String readPropertyFile(String value) throws Exception
//	{
//		Properties p = new Properties();
//		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\TestData\\config.properties");
//		p.load(file);
//		return p.getProperty(value);
//	}
//	public static String readPropertyFile(String value) throws Exception
//	{
//		Properties p = new Properties();
//		FileInputStream file = new FileInputStream("C:\\Users\\amard\\eclipse-workspace2\\Prog1\\TestData\\config.properties");
//		p.load(file);
//		return p.getProperty(value);
//	}
//	public static String readExcelFile1(int row, int col) throws Exception
//	{
//		FileInputStream file = new FileInputStream("C:\\\\Users\\\\amard\\\\eclipse-workspace2\\\\Prog1\\\\TestData\\\\excelData.xlsx");
//		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
//		String value = excel.getRow(row).getCell(col).getStringCellValue();
//		return value;
//	}
	public static void selectClass(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
}
