package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountryNameCheckInICCRanking {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/test");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		String actualCountryName="Pakistan";
		List<WebElement> countries = driver.findElements(By.xpath("//table/tbody//td[2]"));
		
		boolean flag=false;
		for(WebElement expectedCountryName:countries)
		{
			if(expectedCountryName.getText().equals(actualCountryName))
			{
				System.out.println(actualCountryName+" is found");
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			System.out.println(actualCountryName+" is not found");
		}
	}

}
