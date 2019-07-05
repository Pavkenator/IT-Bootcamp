package page.objects;

import org.openqa.selenium.WebDriver;

import utils.Constant;

public class Home {
	
	// Open home page
	public static void openHomePage(WebDriver driver) {
		driver.get(Constant.URL);
	}
	
	// Navigate to home page
	
	public static  void navigateToHomePage(WebDriver driver) {
		driver.navigate().to(Constant.URL);
	}

}
