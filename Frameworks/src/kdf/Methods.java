package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {

	static WebDriver driver;
	
	public static void openBrowser() {
		driver = new ChromeDriver();
	}
	
	public static void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void navigateToAplication(String url) {
		driver.get(url);
	}
	
	public static void enterUserID(String loc, String locValue, String userName) {
		if(loc.equals("id")){
			driver.findElement(By.id(locValue)).sendKeys(userName);
		}
		else if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).sendKeys(userName);
		}
	}
	
	public static void enterPassword(String loc, String locValue, String password) {
		if(loc.equals("id")) {
		driver.findElement(By.id(locValue)).sendKeys(password);
		}
		else if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).sendKeys(password);
		}
	}
	
	public static void clickButton(String loc, String locValue) {
		if(loc.equals("id")) {
			driver.findElement(By.id(locValue)).click();
		}
		else if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
	}
	
	public static String verifyErrorMessage(String locValue) {
		String errorMsg = driver.findElement(By.cssSelector(locValue)).getText();
		return errorMsg;
	}
	
	public static void closeApplication() {
		driver.quit();
	}
}
