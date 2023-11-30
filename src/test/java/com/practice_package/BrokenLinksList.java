package com.practice_package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksList {

	public static void main(String[] args) throws IOException {
	
		//launch browser
		WebDriver driver =new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//enter url
		driver.get("https://www.amazon.in/");
		
		//wait for pageload
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//finding all links
		List<WebElement> AllLinks = driver.findElements(By.xpath("//a"));
		
		//create empty ArrayList
		ArrayList<String> list=new ArrayList<String>();
		
		for(WebElement link:AllLinks)
		{
			String eachLink=link.getAttribute("href");
			
			try {
				URL url=new URL(eachLink);
				HttpURLConnection httpUrlConn= (HttpURLConnection) url.openConnection();
				int responseCode=httpUrlConn.getResponseCode();
				
				if(responseCode>=400)
				{
					list.add(eachLink);
					System.out.println(eachLink+"--->"+responseCode);
				}
			} catch (MalformedURLException e) {
				
				//e.printStackTrace();
			}
		}
	}

}
