package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.GenereicUtils.WebDriverUtils;

public class ApprovePendingAccPage extends WebDriverUtils {
	
	@FindBy(name="application_no")
	private WebElement serachTextField;
	
	@FindBy(name="home")
	private WebElement homePageButton;
	
	public WebElement getSerachTextField() {
		return serachTextField;
	}
	public WebElement getHomePageButton() {
		return homePageButton;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	@FindBy(name="search_application")
	private WebElement searchButton;
	
	public ApprovePendingAccPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void approveAcc(String appNo,WebDriver driver)
	{
		serachTextField.sendKeys(appNo);
		
		
		try
		{
			searchButton.click();
			try
			{
				
				alertPopupAccept(driver);
			}
			catch(Exception e)
			{
				
			}
			
		}
		catch(Exception e)
		{
			System.err.println("Failed");
		}
	}
	
	public void clickOnHomeButton()
	{
		homePageButton.click();
	}
}
