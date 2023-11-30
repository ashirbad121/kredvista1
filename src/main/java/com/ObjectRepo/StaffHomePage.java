package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {

	@FindBy(name="home")
	private WebElement homePageButton;
	
	@FindBy(name="logout_btn")
	private WebElement logOutButton;
	
	@FindBy(name="viewdet")
	private WebElement viewActiveCustTab;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement viewCustByAccNoTab;
	
	@FindBy(name="apprvac")
	private WebElement approvePendingAccTab;
	
	@FindBy(name="del_cust")
	private WebElement deleteCustAccTab;
	
	@FindBy(name="credit_cust_ac")
	private WebElement creditCustTab;
	
	
	
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomePageButton() {
		return homePageButton;
	}

	public WebElement getLogOutButton() {
		return logOutButton;
	}

	public WebElement getViewActiveCustTab() {
		return viewActiveCustTab;
	}

	public WebElement getViewCustByAccNoTab() {
		return viewCustByAccNoTab;
	}

	public WebElement getApprovePendingAccTab() {
		return approvePendingAccTab;
	}

	public WebElement getDeleteCustAccTab() {
		return deleteCustAccTab;
	}

	public WebElement getCreditCustTab() {
		return creditCustTab;
	}
	
	//Business Logic
	public void clickOnHomeButton()
	{
		homePageButton.click();
	}
	
	public void clickOnLogOutButton()
	{
		logOutButton.click();
	}
	
	public void clickOnviewActiveCustTab()
	{
		viewActiveCustTab.click();
	}
	
	public void clickOnviewCustByAccNoTab()
	{
		viewCustByAccNoTab.click();
	}
	
	public void clickOnapprovePendingAccTab()
	{
		approvePendingAccTab.click();
	}
	
	public void clickOndeleteCustAccTab()
	{
		deleteCustAccTab.click();
	}
	
	public void clickOncreditCustTab()
	{
		creditCustTab.click();
	}

	
		
	
	
}
