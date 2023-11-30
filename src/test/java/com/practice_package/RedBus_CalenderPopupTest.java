package com.practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus_CalenderPopupTest {

	public static void main(String[] args) throws InterruptedException {
		
		//to avoid notification popup
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//launching browser
		WebDriver driver=new ChromeDriver(options);
		
		//maximize browser
		driver.manage().window().maximize();
		
		//navigate to URL
		driver.get("https://www.redbus.in/");
		
		//click on calender popup
		driver.findElement(By.className("labelCalendarContainer")).click();
		
		//select a date
		for(;;)
		{
			try
			{		
		driver.findElement(By.xpath("//div[text()='Dec' and text()='2024']/ancestor::div[@class='sc-jzJRlG dPBSOp']/descendant::span[text()='15']")).click();
		break;
			}
			catch(Exception e)
			{
			
				//driver.findElement(By.xpath("(//*[name()='svg' and @id='Layer_1'])[2]")).click();
				try
				{
					driver.findElement(By.xpath("(//*[@id='Layer_1'])[2]")).click();
				}
				catch(Exception e1)
				{
					driver.findElement(By.xpath("//*[@id='Layer_1']")).click();
				}
				
				//Thread.sleep(3000);
			}
	}

}
}
