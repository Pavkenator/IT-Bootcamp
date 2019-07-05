package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.RegPage;
import utils.Constant;
import utils.ExcelUtils;

public class RegPageTest {

	// manual registration

	public static String regUser(WebDriver driver, Scanner scan) throws Exception {
		System.out.println("Please register:");
		scan.nextLine();
		// name

		System.out.println("Please enter your name:");
		RegPage.clickOnFirstName(driver);
		String firstName = scan.nextLine();
		RegPage.insertFirstName(driver, firstName);

		// last name

		System.out.println("Please enter your last name:");
		RegPage.clickOnLastName(driver);
		String lastName = scan.nextLine();
		RegPage.insertLastName(driver, lastName);

		// username

		System.out.println("Please enter your username:");
		RegPage.clickUsername(driver);
		String username = scan.nextLine();
		RegPage.insertUsername(driver, username);

		// email

		System.out.println("Please enter your email:");
		RegPage.clickEmail(driver);
		String email = scan.nextLine();
		RegPage.insertEmail(driver, email);

		// password

		System.out.println("Please enter your password");
		RegPage.clickPassword(driver);
		String password = scan.nextLine();
		RegPage.insertPassword(driver, password);

		// final

		RegPage.clickRegButton(driver);

		
		if(driver.getCurrentUrl().equals(Constant.URL)) {
			System.out.println("Succesfull registration!");
		}else {
			System.out.println("Unsuccessful register!");
		}
		return null;
	}
	
	public static void testRegUser(WebDriver driver, Scanner scan) throws Exception {
		
		regUser(driver, scan);
		LoginPageTest.manualLogin(driver, scan);

	}

	// automatic registration using Excel data

	public static void autoReg(WebDriver driver, int n) throws Exception {

		String info;
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_REG);
		
		// First name
		
		RegPage.clickOnFirstName(driver);
		info= ExcelUtils.getCellData(n, 0);
		RegPage.insertFirstName(driver, info);
		
		// Last name
		
		RegPage.clickOnLastName(driver);
		info= ExcelUtils.getCellData(n, 1);
		RegPage.insertLastName(driver, info);
		
		// Username
		
		RegPage.clickUsername(driver);
		info= ExcelUtils.getCellData(n, 2);
		RegPage.insertUsername(driver, info);
		
		// Email
		
		RegPage.clickEmail(driver);
		info = ExcelUtils.getCellData(n, 3);
		RegPage.insertEmail(driver, info);
		
		// Password
		
		RegPage.clickPassword(driver);
		info = ExcelUtils.getCellData(n, 4);
		RegPage.insertPassword(driver, info);		

		// Final
		
		RegPage.clickRegButton(driver);
		
		if(driver.getCurrentUrl().equals(Constant.URL)) {
			System.out.println("Succesfull registration!");
		}else {
			System.out.println("Unsuccessful register!");
		}
		
	}
	
	public static void testAutoReg(WebDriver driver, int i) throws Exception {
		autoReg(driver, i);
		LoginPageTest.testLogin(driver, i);
		
		if(driver.getCurrentUrl().equals(Constant.URL)) {
			System.out.println("Succesfull registration!");
		}else {
			System.out.println("Unsuccessful register!");
		}
	}
}
