package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ActiveCustomerPage {
	
	public ActiveCustomerPage(WebDriver driver)
	{
		//PageFactory.initElements(driver, this);
	}
	public String FindCustomerAccNoFromPan(String expectedPanNo,WebDriver driver)
	{
		String accNo = driver.findElement(By.xpath("//tr/td[.='"+expectedPanNo+"']/preceding-sibling::td[5]")).getText();
	return accNo;
	
		
	}
}
