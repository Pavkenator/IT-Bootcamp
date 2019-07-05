package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.*;

public class RegPage {

	private static final String FIRST_NAME = "//input[@name='firstname']";
	private static final String LAST_NAME = "//input[@name='lastname']";
	private static final String USERNAME = "//div[@class='register_form']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String PASSWORD = "//div[@class='register_form']//input[@name='password']";
	private static final String REG_PAGE_BUTTON = "//input[@id='blue_btn']";


	// get the first name
	public static WebElement getFirstName(WebDriver driver) {
		WebElement firstName = driver.findElement(By.xpath(FIRST_NAME));
		return firstName;

	}

	// click the first name field
	public static void clickOnFirstName(WebDriver driver) {
		getFirstName(driver).click();

	}
	// insert first name

	public static void insertFirstName(WebDriver driver, String name) {
		getFirstName(driver).sendKeys(name);
	}

	// get the last name
	public static WebElement getLastName(WebDriver driver) {
		WebElement lastName = driver.findElement(By.xpath(LAST_NAME));
		return lastName;

	}

	// click the last name field
	public static void clickOnLastName(WebDriver driver) {
		getLastName(driver).click();

	}

	// insert last name
	public static void insertLastName(WebDriver driver, String lastName) {
		getLastName(driver).sendKeys(lastName);

	}

	// get the username
	public static WebElement getUsername(WebDriver driver) {
		WebElement username = driver.findElement(By.xpath(USERNAME));
		return username;

	}

	// click the username field
	public static void clickUsername(WebDriver driver) {
		getUsername(driver).click();

	}

	// insert username name
	public static void insertUsername(WebDriver driver, String username) {
		getUsername(driver).sendKeys(username);

	}

	// get the email
	public static WebElement getEmail(WebDriver driver) {
		WebElement email = driver.findElement(By.xpath(EMAIL));
		return email;

	}

	// click the email field
	public static void clickEmail(WebDriver driver) {
		getEmail(driver).click();

	}

	// insert email
	public static void insertEmail(WebDriver driver, String email) {
		getEmail(driver).sendKeys(email);
	}

	// get the password
	public static WebElement getPassword(WebDriver driver) {
		WebElement password = driver.findElement(By.xpath(PASSWORD));
		return password;

	}

	// click the password
	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();

	}

	// insert password
	public static void insertPassword(WebDriver driver, String password) {
		getPassword(driver).sendKeys(password);
	}

	// get register button
	public static WebElement getRegButton(WebDriver driver) {
		WebElement regButton = driver.findElement(By.xpath(REG_PAGE_BUTTON));
		return regButton;
	}

	// click on the register button
	public static void clickRegButton(WebDriver driver) {
		getRegButton(driver).click();

	}

}
