package com.house.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.house.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException {
		super();
		
	}


	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=20;
	public static final String CUSTOMER_EMAIL="krithika2010@gmail.com";
	public static final String ITEM_NAME="car";
	public static final String MESSAGE="Kindly, call before coming";
	public static String TESTDATA_SHEET_PATH = "D:\\LMS_API\\Housecall_automation\\src\\main\\java\\com"
			+ "\\house\\qa\\testdata\\HouseCallTestData.xls";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("D:\\LMS_API\\Housecall_automation\\test-output\\screenShots\\"+ timestamp()+ ".png");
		FileUtils.copyFile(scrFile, destFile);
	}
	
	public static String timestamp()
	{
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}


	
}
