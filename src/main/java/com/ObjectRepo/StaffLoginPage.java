package com.ObjectRepo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.GenereicUtils.FileUtils;

public class StaffLoginPage extends FileUtils{

	@FindBy(name="staff_id")
	private WebElement StaffUN;
	
	@FindBy(name="password")
	private WebElement StaffPWD;
	
	@FindBy(name="staff_login-btn")
	private WebElement loginButton;
	
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getStaffUN() {
		return StaffUN;
	}


	public WebElement getStaffPWD() {
		return StaffPWD;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business Logic
	public void StaffLogin(String UN,String PWD) throws Throwable
	{
		StaffUN.sendKeys(UN);
		StaffPWD.sendKeys(PWD);
		loginButton.click();
		
	}
	

}
