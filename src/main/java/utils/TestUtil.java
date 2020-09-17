package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase {

	public static long pageLoadTimeout = 20;

	public static long implictWaitTime = 10;

	public static Workbook book;
	public static Sheet sheet;
	public static Object[][] data;

	public static Object[][] gettestdata(String sheetname) {

		FileInputStream file = null;

		try {

			file = new FileInputStream(Constants.testDataPath);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}

		return data;

	}
	
	
	
	public static void clickONListElement(List<WebElement> element,String expectedtext) {
		
		for (WebElement ele : element) {
			if(ele.getText().equalsIgnoreCase(expectedtext)) {
				ele.click();
				break;
			};
		}
	}
	
public static void enterTextONListElement(List<WebElement> element,String expectedtext,String input) {
		
		for (WebElement ele : element) {
			if(ele.getText().equalsIgnoreCase(expectedtext)) {
				ele.sendKeys(input);
				break;
			}
		}
		
}
		
		
@DataProvider
	public Object[][] gettestdata() {
		data = TestUtil.gettestdata(Constants.sheetName1);
		return data;
	}

}
