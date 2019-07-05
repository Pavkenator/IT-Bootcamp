package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditPosts {

	private static final String POSTS = "posts";
	private static final String DOTS = "fa-ellipsis-v";
	private static final String EDIT_DOTS = "fa-edit";
	private static final String DELETE_POST = "fa-trash-alt";
	private static final String EDIT_TITLE = "//input[@id='title']";
	private static final String EDIT_LOCATION = "//input[@id='location']";
	private static final String EDIT_IMAGE = "editImage";
	private static final String EDIT_TRANSPORTATION = "//select[@id='transport']";
	private static final String EDIT_DESCRIPTION = "//textarea[@id='description']";
	private static final String EDIT_POST_BUTTON = "//div[@class='popupEdit']//input[@name='postSubmit']";

	// Get edit/delete post

	public static WebElement getEditPost(WebDriver driver, int n) {
		List<WebElement> list = driver.findElements(By.className(POSTS));
		WebElement edit = list.get(n);
		return edit;
	}

	// Click on edit/delete post

	public static void clickEditPost(WebDriver driver, int n) {
		getEditPost(driver, n).click();
	}

	// Locate edit dots

	public static WebElement getDots(WebDriver driver, int n) {
		clickEditPost(driver, n);
		List<WebElement> list = driver.findElements(By.className(DOTS));
		WebElement dots = list.get(n);
		return dots;
	}

	// Click edit dots

	public static void clickDots(WebDriver driver, int n) {
		getDots(driver, n).click();

	}

	// Locate edit

	public static WebElement getEditIcon(WebDriver driver, int n) {
		clickDots(driver, n);
		List<WebElement> list = driver.findElements(By.className(EDIT_DOTS));
		WebElement edit = list.get(n);
		return edit;
	}

	// Click edit

	public static void clickEditIcon(WebDriver driver, int n) throws InterruptedException {
		getEditIcon(driver, n).click();
		Thread.sleep(5000);

	}

	// Edit title

	public static WebElement getEditPostTitle(WebDriver driver) {
		WebElement editPost = driver.findElement(By.xpath(EDIT_TITLE));
		return editPost;
	}

	// Click to edit

	public static void clickEditPostTitle(WebDriver driver) {
		getEditPostTitle(driver).click();
	}

	// Set edited post title

	public static void setEditedPostTitle(WebDriver driver, String edit) {
		getEditPostTitle(driver).clear();
		getEditPostTitle(driver).sendKeys(edit);

	}

	// Locate edit location field

	public static WebElement getEditLocation(WebDriver driver) {
		WebElement editLocation = driver.findElement(By.xpath(EDIT_LOCATION));
		return editLocation;

	}

	// Click edit location field

	public static void clickEditLocation(WebDriver driver) {
		getEditLocation(driver).click();

	}

	// Set edited location

	public static void setEditedLocation(WebDriver driver, String location) {
		getEditLocation(driver).clear();
		getEditLocation(driver).sendKeys(location);
	}

	// Locate edit image

	public static WebElement getEditImage(WebDriver driver) {
		WebElement image = driver.findElement(By.id(EDIT_IMAGE));
		return image;
	}

	// Set new image

	public static void setEditedImage(WebDriver driver) {
		getEditImage(driver).sendKeys(Posts.IMG);

	}

	// Select and edit transportation

	public static WebElement setEditTransportation(WebDriver driver, String transport) {
		Select transportation = new Select(driver.findElement(By.xpath(EDIT_TRANSPORTATION)));
		transportation.selectByVisibleText(transport);
		return null;

	}

	// Locate description

	public static WebElement getEditDescription(WebDriver driver) {
		WebElement description = driver.findElement(By.xpath(EDIT_DESCRIPTION));
		return description;
	}

	// Click description

	public static void clickEditDescription(WebDriver driver) {
		getEditDescription(driver).click();
	}

	// Set edited description

	public static void setEditedDescription(WebDriver driver, String description) {
		getEditDescription(driver).clear();
		getEditDescription(driver).sendKeys(description);

	}

	// Locate submit button

	public static WebElement getEditButton(WebDriver driver) {
		WebElement button = driver.findElement(By.xpath(EDIT_POST_BUTTON));
		return button;
	}

	// Click submit button

	public static void clickEditPostButton(WebDriver driver) {
		getEditButton(driver).click();
	}

	// Locate delete element

	public static WebElement getDelete(WebDriver driver, int n) {
		clickDots(driver, n);
		List<WebElement> list = driver.findElements(By.className(DELETE_POST));
		WebElement delete = list.get(n);
		return delete;
	}

	// Click on delete

	public static void clickDelete(WebDriver driver, int n) {
		getDelete(driver, n).click();
	}

}
