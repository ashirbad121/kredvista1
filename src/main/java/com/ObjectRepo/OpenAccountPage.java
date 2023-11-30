package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.GenereicUtils.JavaUtils;

public class OpenAccountPage {

	@FindBy(name="submit")
	private WebElement submitButton;
	
	public OpenAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openAccount(WebDriver driver,HashMap<String,String> map)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			JavaUtils jutil=new JavaUtils(); 
			if(set.getKey().equals("pan_no"))
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			else if(set.getKey().equals("dob"))
			{
					 WebElement calenderPopUp = driver.findElement(By.name("dob"));
					 JavascriptExecutor js=(JavascriptExecutor) driver;
					 js.executeScript("arguments[0].value='12122000'", calenderPopUp);
			}
			else
			{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		}
		
	}
	public void clickOnSubmitButton()
	{
		submitButton.click();
	}
}
