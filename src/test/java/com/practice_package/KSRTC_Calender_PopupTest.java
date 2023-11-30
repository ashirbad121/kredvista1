package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_Calender_PopupTest {

	public static void main(String[] args) {
		//launching empty browser
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//enter URL
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		//wait for page load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for clicking on calender popup
		driver.findElement(By.id("txtJourneyDate")).click();
		
		//for clicking on a date
		for(;;)
		{
			
		
			try
			{
				driver.findElement(By.xpath("//span[.='December']/following-sibling::span[.='2023']/ancestor::div[@id='ui-datepicker-div']/descendant::a[.='7']")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//a[@data-handler=\"next\"]")).click();
			}
		}
	}

}
