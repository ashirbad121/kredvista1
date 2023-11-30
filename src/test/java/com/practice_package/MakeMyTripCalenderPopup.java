package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripCalenderPopup {

	public static void main(String[] args) throws InterruptedException {
	//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//launch browser
		WebDriver driver=new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//navigate to URL
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Thread.sleep(10000);
		
		Actions action=new Actions(driver);
		action.moveByOffset(0, 100).perform();
		action.click().perform();
		
		Thread.sleep(2000);
		action.click().perform();
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(null)
		//driver.findElement(By.xpath("//a[@class='close']")).click();	
		
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[text()='November 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='1']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		
		

	}

}
