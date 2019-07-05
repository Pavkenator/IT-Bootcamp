package start;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.Home;
import page.objects.RegPage;
import page.tests.HomeTest;
import page.tests.LoginPageTest;

import page.tests.RegPageTest;
import page.tests.TestEditPosts;
import page.tests.TestPosts;

public class FinalDestination {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		WebDriver driver = new ChromeDriver();
		// Open home page with maximized view
		driver.manage().window().maximize();

		try {
			Home.openHomePage(driver);

			System.out.println("If you want to do manual testing, type in number 1");
			System.out.println("If you want to do automatic testing, type in nymber 2");

			int n = scan.nextInt();

			while (n != 1 && n != 2) {
				System.out.println("Please choose case 1 or 2");
				n = scan.nextInt();
			}
			if (n == 1) { // Manual part

				// Register and login

				RegPageTest.testRegUser(driver, scan);
				System.out.println("Please login with your data:");

				// Make a post

				TestPosts.makeAPost(driver, scan);

				// Edit post
				TestEditPosts.editPost(driver, scan, 0);

				// Delete first post

				TestEditPosts.deleteOnePost(driver, 0);

				// Log out
				LoginPageTest.LogOut(driver);
			}

			if (n == 2) { // Automatic part

				System.out.println("Automatic script is running...");
				
				// Login and logout users from 
				 HomeTest.autoLoginTest(driver);
				 Thread.sleep(3000);
				
				//Login one user to be able to make a post
				LoginPageTest.testLogin(driver, 1);

				// Make posts from Excel file
			
				TestPosts.autoMakePosts(driver, "Car");
				
				// Delete first two posts
				TestEditPosts.deletePosts(driver, 2);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			driver.quit();
			System.out.println("Finished for today!");
		}
	}
}