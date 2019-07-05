package page.tests;

import org.openqa.selenium.WebDriver;

import page.objects.Posts;
import utils.Constant;
import utils.ExcelUtils;
import page.objects.Posts;
import java.util.Scanner;

public class TestPosts {

	// Make a post manually

	public static void makeAPost(WebDriver driver, Scanner scan) throws InterruptedException {

		// Clicks the make a post button

		Posts.clickOnMakeAPost(driver);

		// Sets title
		System.out.println("Please enter the title:");
		Posts.clickOnAPostTitle(driver);
		String title = scan.nextLine();
		Posts.enterPostTitle(driver, title);

		// Sets location

		System.out.println("Please set the location:");
		Posts.clickOnALocation(driver);
		String location = scan.nextLine();
		Posts.enterLocation(driver, location);

		// Sets the image

		Posts.setImage(driver);
		System.out.println("Please wait for image to load...");
		Thread.sleep(2000);

		// Sets the transportation

		System.out.println("Please choose the transportation:");
		System.out.println("Walk, Car, Motorbike, Bicycle, Bus");
		String transport = scan.nextLine();
		Posts.transport(driver, transport);

		// Sets the description

		System.out.println("Please enter description:");
		Posts.clickOnDescription(driver);
		String description = scan.nextLine();
		Posts.enterDescription(driver, description);

		// Finally, make a post

		Posts.clickOnPostButton(driver);

	}

	// Make a post automatically

	public static void autoMakeAPost(WebDriver driver, int n, String transport) throws Exception {


		// Set Excel file

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_POST);

		// New Post button

		Posts.clickOnMakeAPost(driver);

		// Title
		Posts.clickOnAPostTitle(driver);
		String title = ExcelUtils.getCellData(n, 1);
		Posts.enterPostTitle(driver, title);

		// Location
		
		Posts.clickOnALocation(driver);
		String location = ExcelUtils.getCellData(n, 2);
		Posts.enterLocation(driver, location);
		
		// Image
		
		Posts.setImage(driver);
		
		// Transportation
		
		Posts.transport(driver, transport);
		
		// Description
		
		Posts.clickOnDescription(driver);
		String description = ExcelUtils.getCellData(n, 0);
		Posts.enterDescription(driver, description);
		
		// Submit button
		
		Posts.clickOnPostButton(driver);
		
		if(driver.getCurrentUrl().equals(Constant.DASHBOARD)) {
			System.out.println("Post succesfull!");
			
		}else {
			System.out.println("Post unsucessfull");
		}
		
		
	}

	// Make more posts automatically

	public static void autoMakePosts(WebDriver driver, String string) throws Exception {

		// Set the Excel file for posts

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_POST);

		for (int i = 1; i < ExcelUtils.getRowCount(Constant.SHEET_POST); i++) {
			autoMakeAPost(driver, i, string);

		}
		if (driver.getCurrentUrl().equals(Constant.DASHBOARD)) {
			System.out.println("Post succesfull!");
		} else {
			System.out.println("Post unsucessfull");
		}
	}

}
