package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AirIndia_Calender_PopupTest {

	public static void main(String[] args) {
		//launching empty browser
				WebDriver driver=new ChromeDriver();
				
				//maximize the browser
				driver.manage().window().maximize();
				
				//enter URL
				driver.get("https://www.airindia.com/");
				
				//wait for page load
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			    //driver.findElement(By.xpath("//button[text()='Manage Cookies']/preceding-sibling::button")).click();
				
				
				//click on year from dropdown
				driver.findElement(By.xpath("//input[@name='dpFromDate']")).click();
				
				
	}

}
