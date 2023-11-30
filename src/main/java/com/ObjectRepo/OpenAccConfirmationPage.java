package com.ObjectRepo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccConfirmationPage {

	@FindBy(name="cnfrm-submit")
	private WebElement confirmButton;
	
	public OpenAccConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnConfirmButton()
	{
		confirmButton.click();
	}
	
	public String appNoCollection(WebDriver driver)
	{
		//collecting application number from popup
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		String appNo="";
		for(int i=0;i<text.length();i++)
		{
			if(Character.isDigit(text.charAt(i)))
			{
				appNo=appNo+text.charAt(i);
			}
		}
		return appNo;
	}
}
