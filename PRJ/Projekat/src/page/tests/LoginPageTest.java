package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LoginPage;
import utils.*;

public class LoginPageTest {

	// manual login

	public static void manualLogin(WebDriver driver, Scanner scan) {

		// Enter username
		System.out.println("Please enter your username:");
		LoginPage.clickOnUserName(driver);
		String username = scan.nextLine();
		LoginPage.enterUserName(driver, username);

		// Enter password
		System.out.println("Please enter your password:");
		LoginPage.clickOnPassword(driver);
		String password = scan.nextLine();
		LoginPage.enterPassword(driver, password);

		// Proceed
		LoginPage.clickLoginButton(driver);
		if (driver.getCurrentUrl().equals(Constant.DASHBOARD)) {
			System.out.println("You have succesfully logged in!");
		} else
			System.out.println("Loggin failed!");

	}

	// Login using Excel info

	public static void autoLogin(WebDriver driver, int n) throws Exception {

		String info;

		// Set Excel file

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_REG);

		// Username

		LoginPage.clickOnUserName(driver);
		info = ExcelUtils.getCellData(n, 2);
		LoginPage.enterUserName(driver, info);

		// Password

		LoginPage.clickOnPassword(driver);
		info = ExcelUtils.getCellData(n, 4);
		LoginPage.enterPassword(driver, info);

		// Final

		LoginPage.clickLoginButton(driver);

	}
	
	// Test auto login

	public static void testLogin(WebDriver driver, int n) throws Exception {
		autoLogin(driver, n);

	}
	
	// Log out

	public static void LogOut(WebDriver driver) {
		LoginPage.clickLogOutButton(driver);
		
		if (driver.getCurrentUrl().equals(Constant.URL)){
			System.out.println("Successfully logged out!");
			
		}else {
			System.out.println("Failed to log out!");
		}
	}
}
