package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.GenereicUtils.WebDriverUtils;

public class HomePage extends WebDriverUtils {

	@FindBy(linkText="Staff Login")
	private WebElement staffLoginLink;
	
	@FindBy(xpath="//li[.='Open Account']")
	private WebElement openAccTab;
	
	@FindBy(xpath="//li[.='Apply Debit Card']")
	private WebElement applyDebitCardTab;
	
	@FindBy(id="ebanking")
	private WebElement internetBankingTab;
	
	@FindBy(xpath="//li[.='Login ']")
	private WebElement internetBankingLoginLink;
	
	@FindBy(xpath="//li[.='Register']")
	private WebElement internetBankingRegisterLink;
	
	@FindBy(xpath="//li[.='Fund Transfer']")
	private WebElement FundTransferTab;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaffLoginLink() {
		return staffLoginLink;
	}

	public WebElement getOpenAccTab() {
		return openAccTab;
	}

	public WebElement getApplyDebitCardTab() {
		return applyDebitCardTab;
	}

	public WebElement getInternetBankingTab() {
		return internetBankingTab;
	}

	public WebElement getInternetBankingLoginLink() {
		return internetBankingLoginLink;
	}

	public WebElement getInternetBankingRegisterLink() {
		return internetBankingRegisterLink;
	}
	
	public WebElement getFundTransferTab() {
		return FundTransferTab;
	}
	
	//Business Logic
	
	public void clickOnOpenAccTab()
	{
		openAccTab.click();
	}
	
	public void clickOnapplyDebitCardTab()
	{
		applyDebitCardTab.click();
	}
	
	public void clickOninternetBankingLoginLink(WebDriver driver)
	{
		mouseHover(driver, internetBankingTab);
		internetBankingLoginLink.click();
	}
	
	public void clickOninternetBankingRegisterLink(WebDriver driver)
	{
		mouseHover(driver, internetBankingTab);
		internetBankingRegisterLink.click();
	}
	
	public void clickOnFundTransferTab()
	{
		FundTransferTab.click();
	}
	
	public void clickOnStaffLoginLink()
	{
		staffLoginLink.click();
	}
	
	
	
	
	
}
