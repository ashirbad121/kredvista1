package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Irctc_Calender_PopupTest {

	public static void main(String[] args) {
		
		//to avoid notification popup
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				//launching browser
				WebDriver driver=new ChromeDriver(options);
				
				//maximize browser
				driver.manage().window().maximize();
				
				//navigate to URL
				driver.get("https://www.irctc.co.in/nget/train-search");
				
				//wait for page load
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				
				//click on calender popup
				driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']")).click();
				
				
				for(;;)
				{
					
					try {
						
				
				//select a date
				driver.findElement(By.xpath("//span[text()='December']/following-sibling::span[text()='2023']/ancestor::div[contains(@class,'ui-datepicker-group')]/descendant::a[text()='15']")).click();
					}
					catch(Exception e)
					{
						driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-next')]")).click();
					}
				}
				}
				

}
