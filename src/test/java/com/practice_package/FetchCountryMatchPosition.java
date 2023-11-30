package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchCountryMatchPosition {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		List<WebElement> positions = driver.findElements(By.xpath("//table/tbody//td[1]"));
		List<WebElement> country = driver.findElements(By.xpath("//table/tbody//td[2]"));
		List<WebElement> matches = driver.findElements(By.xpath("//table/tbody//td[3]"));
		
		for(int i=0;i<country.size();i++)
		{
			System.out.println(country.get(i).getText()+" "+positions.get(i).getText()+" "+matches.get(i).getText());
		}
	}

}
