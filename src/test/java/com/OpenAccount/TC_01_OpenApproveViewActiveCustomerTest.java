package com.OpenAccount;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.ApprovePendingAccPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.OpenAccConfirmationPage;
import com.ObjectRepo.OpenAccountPage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.onlinebanking.GenereicUtils.ExcelUtils;
import com.onlinebanking.GenereicUtils.FileUtils;
import com.onlinebanking.GenereicUtils.JavaUtils;
import com.onlinebanking.GenereicUtils.WebDriverUtils;

public class TC_01_OpenApproveViewActiveCustomerTest {

	@Test()
	public void TC_01() throws IOException, InterruptedException, Throwable
	{
	/*	//property file handling for common data
		FileUtils fUtil=new FileUtils();
		String URL=fUtil.readDataFromPropertyFile("url");
		String StaffUSERNAME=fUtil.readDataFromPropertyFile("staffUsername");
		String staffPassword=fUtil.readDataFromPropertyFile("staffPassword");
		
		//Java Utility file handling for random no generation
		JavaUtils jUtil=new JavaUtils();
		int random=jUtil.getRandomNo();
		
		//WebDriverUtil for doing web browser operations
		WebDriverUtils wUtil=new WebDriverUtils();
		
		//excel file handling for testscript data
		ExcelUtils eUtil=new ExcelUtils();
		HashMap<String, String> map = eUtil.readMultipleData("OpenAccount");

	
	
	
	//launch browser 
	WebDriver driver=new ChromeDriver();
	//maximize browser
	wUtil.maximizeWindow(driver);
	//navigate to URL
	driver.get(URL);
	
	wUtil.waitForPageLoad(driver, 20);
	
	//click on open account tab 
	HomePage hp=new HomePage(driver);
	hp.clickOnOpenAccTab();
	
	//online account opening form fillup & click on submit
	OpenAccountPage oap=new OpenAccountPage(driver);
	oap.openAccount(driver, map);
	oap.clickOnSubmitButton();
	
	//click on confirm on confirmation page
	OpenAccConfirmationPage oacp=new OpenAccConfirmationPage(driver);
	oacp.clickOnConfirmButton();
	
	
	//collecting application number from popup
	String text=wUtil.alertPopupGetText(driver);
	wUtil.alertPopupAccept(driver);
	String appNo="";
	for(int i=0;i<text.length();i++)
	{
		if(Character.isDigit(text.charAt(i)))
		{
			appNo=appNo+text.charAt(i);
		}
	}
	
	//staff login
	hp.clickOnStaffLoginLink();
	StaffLoginPage slp=new StaffLoginPage(driver);
	slp.StaffLogin(StaffUSERNAME, staffPassword);
	
	//approving account
	StaffHomePage shp=new StaffHomePage(driver);
	shp.clickOnapprovePendingAccTab();
	
	ApprovePendingAccPage apa=new ApprovePendingAccPage(driver);
	apa.approveAcc(appNo,driver);
	
	
	//view active cust and verify
	driver.findElement(By.name("home")).click();
	driver.findElement(By.name("viewdet")).click();
	String expectedPanNo=map.get("pan_no");
	System.out.println(expectedPanNo);
	List<WebElement> panNos = driver.findElements(By.xpath("//tbody//td[9]"));
	boolean flag=false;
	for(WebElement actualPanNo:panNos)
	{
		if(actualPanNo.getText().equals(expectedPanNo))
		{
			System.out.println("Acc details found in active customer section");
			flag=true;
			break;
		}
	}
	if(!flag)
	{
		System.err.println("Acc details not found in active customer section");
	}
	
	Thread.sleep(2000);
	driver.close();
	
	
	
	
	
	
*/
	
	
	}

}
