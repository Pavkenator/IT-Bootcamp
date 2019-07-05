package page.tests;

import org.openqa.selenium.WebDriver;

import utils.Constant;
import utils.ExcelUtils;

public class HomeTest {

	public static void autoLoginTest(WebDriver driver) throws Exception {

		// Set the Excel file

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_REG);
		for (int i = 1; i < ExcelUtils.getRowCount(Constant.SHEET_REG); i++) {
			RegPageTest.testAutoReg(driver, i);
			
			if (driver.getCurrentUrl().equals(Constant.DASHBOARD)){
			System.out.println("Successfully logged in!");
				LoginPageTest.LogOut(driver);
			}
			
			else {
				driver.navigate().to(Constant.URL);
			}

		}
	}
}
