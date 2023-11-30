package com.HomeWork1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		List<WebElement> teamNames = driver.findElements(By.xpath("//div[@class='team-name']"));
		List<WebElement> matchesPlayed = driver.findElements(By.xpath("//div[@class='table-data matches-play']"));
		List<WebElement> matchesWon = driver.findElements(By.xpath("//div[@class='table-data matches-won']"));
		List<WebElement> matchesLost = driver.findElements(By.xpath("//div[@class='table-data matches-lost']"));
		List<WebElement> matchesDraw = driver.findElements(By.xpath("//div[@class='table-data matches-draw']"));
		List<WebElement> scoreDiff = driver.findElements(By.xpath("//div[@class='table-data points']"));
		
		for(int i=0;i<teamNames.size();i++)
		{
			System.out.println(teamNames.get(i).getText()+" "+matchesPlayed.get(i).getText()+" "+matchesWon.get(i).getText()+" "+matchesLost.get(i).getText()+" "+matchesDraw.get(i).getText()+scoreDiff.get(i).getText());
		}
	}

}
