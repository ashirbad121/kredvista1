package com.HomeWork1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cricbuzz {

	public static void main(String[] args) {
		
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.cricbuzz.com/live-cricket-scores/75595/eng-vs-ned-40th-match-icc-cricket-world-cup-2023");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			 List<WebElement> batting = driver.findElements(By.xpath("//h2[@class='cb-font-20 text-bold inline-block ng-binding']/ancestor::div[@class='cb-col cb-col-100 cb-mini-col cb-bg-white cb-min-lv ng-scope']//div[@ng-if=\"match.miniscore.batsman.length > 0\"]"));
			
			
			for(WebElement bat:batting)
			{
				System.out.println(bat.getText());
			}
			
			
		
		
		

	}

}
