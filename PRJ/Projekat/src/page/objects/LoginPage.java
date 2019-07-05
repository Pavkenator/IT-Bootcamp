package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Constant;

public class LoginPage {

	private static final String USERNAME = "//input[@placeholder='username']";
	private static final String PASSWORD = "//input[@placeholder='password']";
	private static final String LOGIN_BUTTON = "//input[@name='login']";
	private static final String LOG_OUT_BUTTON = "//a[@id='logoutBtn']";

	
	
	// get username
	public static WebElement getUserName(WebDriver driver) {
		WebElement userName = driver.findElement(By.xpath(USERNAME));
		return userName;
	}

	// click username field
	public static void clickOnUserName(WebDriver driver) {
		getUserName(driver).click();
	}

	// enter username
	public static void enterUserName(WebDriver driver, String username) {
		getUserName(driver).sendKeys(username);
	}

	// get password
	public static WebElement getPassword(WebDriver driver) {
		WebElement password = driver.findElement(By.xpath(PASSWORD));
		return password;
	}

	// click on password field
	public static void clickOnPassword(WebDriver driver) {
		getPassword(driver).click();
	}

	// enter password
	public static void enterPassword(WebDriver driver, String password) {
		getPassword(driver).sendKeys(password);
	}

	// find login button
	public static WebElement getLoginButton(WebDriver driver) {
		WebElement loginButton = driver.findElement(By.xpath(LOGIN_BUTTON));
		return loginButton;
	}

	// click on the login button
	public static void clickLoginButton(WebDriver driver) {
		getLoginButton(driver).click();
	}

	// find logout button
	public static WebElement getLogOutButton(WebDriver driver) {
		WebElement logout = driver.findElement(By.xpath(LOG_OUT_BUTTON));
		return logout;
	}

	// click logout button
	public static void clickLogOutButton(WebDriver driver) {
		getLogOutButton(driver).click();
	}
}
