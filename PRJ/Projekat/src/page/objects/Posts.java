package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Constant;

public class Posts {

	private static final String MAKE_A_POST = "//a[contains(text(),'Make a post')]";
	private static final String TITLE = "//input[@placeholder='Naziv']";
	private static final String LOCATION = "//input[@placeholder='Lokacija']";
	private static final String BROWSE = "image";
	private static final String TRANSPORTATION = "//div[@class='popupPost']//select[@name='transport']";
	private static final String DESCRIPTION = "//textarea[@placeholder='Opis']";
	private static final String POST_BUTTON = "//div[@class='popupPost']//input[@name='postSubmit']";
	public static final String IMG = "C:\\Users\\vpavi\\Desktop\\PRJ\\Car.jpg";
	
	// Open Dashboard

	public static void makePost(WebDriver driver) {
		driver.get(Constant.DASHBOARD);
	}

	// Locate make a post button

	public static WebElement getMakeAPost(WebDriver driver) {
		WebElement post = driver.findElement(By.xpath(MAKE_A_POST));
		return post;
	}

	// Click ona a post button

	public static void clickOnMakeAPost(WebDriver driver) {
		getMakeAPost(driver).click();
	}

	// Locate a post title

	public static WebElement getPostTitle(WebDriver driver) {
		WebElement postTitle = driver.findElement(By.xpath(TITLE));
		return postTitle;
	}

	// Click on a post title field

	public static void clickOnAPostTitle(WebDriver driver) {
		getPostTitle(driver).click();

	}

	// Enter post title

	public static void enterPostTitle(WebDriver driver, String title) {
		getPostTitle(driver).sendKeys(title);
	}

	// Locate a location field

	public static WebElement getLocation(WebDriver driver) {
		WebElement location = driver.findElement(By.xpath(LOCATION));
		return location;

	}

	// Click on a location field

	public static void clickOnALocation(WebDriver driver) {
		getLocation(driver).click();

	}

	// Enter location info

	public static void enterLocation(WebDriver driver, String location) {
		getLocation(driver).sendKeys(location);
	}

	// Locate browse button

	public static WebElement getBrowseButton(WebDriver driver) {
		WebElement browseButton = driver.findElement(By.id(BROWSE));
		return browseButton;
	}

	// Click on an image

	public static void setImage(WebDriver driver) throws InterruptedException {
		getBrowseButton(driver).sendKeys(IMG);

	}

	// Select and choose transport

	public static void transport(WebDriver driver, String transport) {
		Select transportation = new Select(driver.findElement(By.xpath(TRANSPORTATION)));
		transportation.selectByVisibleText(transport);
	}

	// Locate Description field

	public static WebElement getDescription(WebDriver driver) {
		WebElement description = driver.findElement(By.xpath(DESCRIPTION));
		return description;
	}

	// Click on description field

	public static void clickOnDescription(WebDriver driver) {
		getDescription(driver).click();

	}

	// Enter description

	public static void enterDescription(WebDriver driver, String description) {
		getDescription(driver).sendKeys(description);
	}

	// Locate post button

	public static WebElement getPostButton(WebDriver driver) {
		WebElement postButton = driver.findElement(By.xpath(POST_BUTTON));
		return postButton;

	}

	// Click on a post button

	public static void clickOnPostButton(WebDriver driver) {
		getPostButton(driver).click();

	}

}
