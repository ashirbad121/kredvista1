package com.onlinebanking.GenereicUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ReInit {

	public FileUtils fLib=new FileUtils();
	public WebDriverUtils wLib=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException {
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println("chrome launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			System.out.println("edge launched");
		}
		else {
			System.out.println("---Invalid browser----");
		}
		sdriver=driver;
		wLib.maximizeWindow(driver);
		System.out.println("browser launched");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC() {
		driver.quit();
		System.out.println("---Close browser----");
	}
	
}
