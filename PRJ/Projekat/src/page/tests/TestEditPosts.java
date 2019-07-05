package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.EditPosts;
import utils.Constant;
import utils.ExcelUtils;

public class TestEditPosts {

	// Manual posting

	public static void editPost(WebDriver driver, Scanner scan, int n) throws Exception {

		// Edit post button

		EditPosts.clickEditPost(driver, n);
		Thread.sleep(3000);
		EditPosts.clickEditIcon(driver, n);

		// Title

		System.out.println("Please enter the new title:");
		EditPosts.clickEditPostTitle(driver);
		String title = scan.nextLine();
		EditPosts.setEditedPostTitle(driver, title);

		// Location

		System.out.println("Please enter the new Location:");
		EditPosts.clickEditLocation(driver);
		String location = scan.nextLine();
		EditPosts.setEditedLocation(driver, location);

		// Image

		System.out.println("Please select image");
		EditPosts.setEditedImage(driver);
		System.out.println("Please wait for image to load...");
		Thread.sleep(3000);

		// Transportation

		System.out.println("Please choose the transportation type:");
		System.out.println("Walk, Car, Motorbike, Bicycle, Bus");
		String transport = scan.nextLine();
		EditPosts.setEditTransportation(driver, transport);

		// Description

		System.out.println("Please enter the new description");
		EditPosts.clickEditDescription(driver);
		String description = scan.nextLine();
		EditPosts.setEditedDescription(driver, description);

		// Submit button
		EditPosts.clickEditPostButton(driver);
		
		if(driver.getCurrentUrl().equals(Constant.DASHBOARD)){
			System.out.println("Successfully edited a post!");
		}else {
			System.out.println("Failed to edit a post");
		}

	}
	// Automatic editing

	public static void autoEditPost(WebDriver driver, int i, String str, int n) throws Exception {

		String info;

		// Set the Excel file

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SHEET_POST);

		// Edit post button

		EditPosts.clickEditPost(driver, n);
		EditPosts.clickEditIcon(driver, n);

		// Title

		EditPosts.clickEditPostTitle(driver);
		info = ExcelUtils.getCellData(i, 1);
		EditPosts.setEditedPostTitle(driver, info);

		// Location

		EditPosts.clickEditLocation(driver);
		info = ExcelUtils.getCellData(i, 2);
		EditPosts.setEditedLocation(driver, info);

		// Image

		EditPosts.setEditedImage(driver);
		Thread.sleep(3000);

		// Transportation

		EditPosts.setEditTransportation(driver, str);

		// Description

		EditPosts.clickEditDescription(driver);
		info = ExcelUtils.getCellData(i, 0);
		EditPosts.setEditedDescription(driver, info);

		// Submit changes

		EditPosts.clickEditPostButton(driver);
		
		if(driver.getCurrentUrl().equals(Constant.DASHBOARD)){
			System.out.println("Successfully edited a post!");
		}else {
			System.out.println("Failed to edit a post");
		}
		

	}

	// Delete a post

	public static void deleteOnePost(WebDriver driver, int n) {
		EditPosts.clickDelete(driver, n);

		if (driver.getCurrentUrl().equals(Constant.DASHBOARD)) {
			System.out.println("You have succesfully deleted a post!");

		} else {
			System.out.println("Unsuccessful deletion!");
		}
	}

	// Delete more posts

	public static void deletePosts(WebDriver driver, int n) throws Exception {
		
		// when we delete first post, the second post becomes first

		for (int i = 0, j = 0; j < n; j++) {
			deleteOnePost(driver, i + 1);

		}
		if (driver.getCurrentUrl().equals(Constant.DASHBOARD)) {
			System.out.println("You have succesfully deleted all posts!");

		} else {
			System.out.println("Unsuccessful deletion!");
		}
	}
}