package com.onlinebanking.GenereicUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	/**
	 * This method used to maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	

	/**
	 * This method used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait until page loads
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	/**
	 * This method is used to wait until a webElement is visible
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilElementToBeVisible(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait a webElement is clickable
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement element,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method is used to select a dropdown by the index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	

	/**
	 * This method is used to select a dropdown by the value
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	

	/**
	 * This method is used to select a dropdown by the visible text
	 * @param element
	 * @param index
	 */
	public void dropdown(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(src, dest).perform();;
	}
	
	/**
	 * This method is used to double click on the webpage
	 * @param driver
	 */
	public void doubleClickOnWebPage(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.doubleClick().perform();;
	}
	
	/**
	 * This method is used to double click on a webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnWebElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();;
	}
	
	/**
	 * This method is used to right click on the web page
	 * @param driver
	 */
	public void rightClickOnWebPage(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.contextClick().perform();;
	}
	
	/**
	 * This method is used to right click on a webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();;
	}
	
	/**
	 * This method is used to mouse hover to particular webElement
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
	Actions action=new Actions(driver);
	action.moveToElement(element).perform();;
	}
	/**
	 * This method is used to switch window by name or handle
	 * @param driver
	 * @param windowName
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		//captue all window ids
		Set<String> windowids = driver.getWindowHandles();
		//navigate to each window
		for(String window:windowids)
		{
			//capture window ids
			String windowTitle = driver.switchTo().window(window).getTitle();
			if(windowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
		
	}
	
	/**
	 * This method is used to switch to frames by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrames(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to frames by nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrames(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method is used to switch to a window by using frame webElement address
	 * @param driver
	 * @param element
	 */
	public void switchToFrames(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method is used to press enter key using action class and sendkeys method
	 * @param driver
	 */
	public void keyPress(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * This method is used to press enter key using robot class
	 * @param driver
	 * @throws Throwable
	 */
	public void keyPressEnter(WebDriver driver) throws Throwable
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to relase enter key pressed by the robot class
	 * @param driver
	 * @throws Throwable
	 */
	public void keyReleaseEnter(WebDriver driver) throws Throwable
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method used to accept alert popup
	 * @param driver
	 */
	public void alertPopupAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();;
	}
	
	/**
	 * This method used to dismiss alert popup
	 * @param driver
	 */
	public void alertPopupDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method used to get text of the alert popup
	 * @param driver
	 * @return
	 */
	public String alertPopupGetText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method used to enter text into alert poup
	 * @param driver
	 * @param text
	 */
	public void alertPopupSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)","");
	}
	
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws Throwable
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+screenshotName+".png");
		FileUtils.copyFile(src, dest);
		//FileHandler.copy(src, dest);
		
		return dest.getAbsolutePath();
	}
	
	
	
}
