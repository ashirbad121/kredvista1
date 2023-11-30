package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoIbibo_Calender_PopupTest {

	public static void main(String[] args) {
		
		
		String actualMonth="March 2024";
		String actualDate="8";
		//launching browser
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//navigate to URL
		driver.get("https://www.goibibo.com/");
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//close login popup
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		//click on calender popup
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		
		for(;;)
		{
			
		try {
		//selecting a date
			
			driver.findElement(By.xpath("//div[text()='"+actualMonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+actualDate+"']")).click();
			break;
			
		//driver.findElement(By.xpath("//div[text()='"+actualMonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+actualDate+"']")).click();
	//	break;
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		}
		//click on done
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		
		
		//driver.findElement(By.xpath(actualDate)).click();
	}

}
