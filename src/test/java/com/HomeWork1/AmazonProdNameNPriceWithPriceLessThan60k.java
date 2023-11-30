package com.HomeWork1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProdNameNPriceWithPriceLessThan60k {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		driver.findElement(By.id("high-price")).sendKeys("59999");
		driver.findElement(By.id("a-autoid-1")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//span[contains(@class,'a-size-medium a-color-base ')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		
		for(int i=0;i<products.size();i++)
		{
			System.out.println(products.get(i).getText()+"-->"+prices.get(i).getText());
		}
	}

}
