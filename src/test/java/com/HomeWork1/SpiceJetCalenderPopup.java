package com.HomeWork1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJetCalenderPopup {

	public static void main(String[] args) throws InterruptedException, AWTException {
	
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_I);
		r.keyRelease(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_M);
		r.keyRelease(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_D);
		r.keyRelease(KeyEvent.VK_D);

	
		Thread.sleep(2000);
		
		
		//driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		
		for(;;)
		{
		try
		
		{
			driver.findElement(By.xpath("//div[text()='November ' and text()='2024']/ancestor::div[contains(@class,'css-1dbjc4n r-1md')]/descendant::div[text()='2']")).click();
			break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//*[name()='circle' and @cx='24.5'])[1]")).click();
		}
		}

		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//div[text()='Return Date']")).click();
		
		for(;;)
		{
		try
		{
			driver.findElement(By.xpath("//div[text()='November ' and text()='2024']/ancestor::div[contains(@class,'css-1dbjc4n r-1md')]/descendant::div[text()='4']")).click();
			break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//*[name()='circle' and @cx='24.5'])[1]")).click();
		}
		}
		
		
	
	}

}
