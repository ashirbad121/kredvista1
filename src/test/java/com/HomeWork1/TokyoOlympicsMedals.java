package com.HomeWork1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokyoOlympicsMedals {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		
		List<WebElement> country = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
		List<WebElement> goldMedals = driver.findElements(By.xpath("//div[@title='Gold']"));
		List<WebElement> silverMedals = driver.findElements(By.xpath("//div[@title='Silver']"));
		List<WebElement> bronzeMedals = driver.findElements(By.xpath("//div[@title='Bronze']"));
		List<WebElement> totMedals = driver.findElements(By.xpath("//div[contains(@data-medal-id,'total-medals-row')]"));
		
		for(int i=0;i<country.size();i++)
		{
			System.out.println(country.get(i).getText()+" "+goldMedals.get(i).getText()+" "+silverMedals.get(i).getText()+" "+bronzeMedals.get(i).getText()+" "+totMedals.get(i).getText());
			
		}
	}

}
