package com.HomeWork1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICCWomenTeamRanking {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/homepage");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[contains(text(),\"Women's\")]/ancestor::div[@class='main-navigation__header u-hide-desktop']/descendant::a[@href='/rankings/womens/team-rankings']"));

	}

}
