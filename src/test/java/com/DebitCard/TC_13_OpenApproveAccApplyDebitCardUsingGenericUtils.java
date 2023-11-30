package com.DebitCard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ObjectRepo.ActiveCustomerPage;
import com.ObjectRepo.ApplyDebitCardPage;
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

public class TC_13_OpenApproveAccApplyDebitCardUsingGenericUtils {

	@Test()
	public void TC_13Test() throws Throwable
	{
	//property file handling for common data
	FileUtils fUtil=new FileUtils();
	String URL=fUtil.readDataFromPropertyFile("url");
	String StaffUSERNAME=fUtil.readDataFromPropertyFile("staffUsername");
	String staffPassword=fUtil.readDataFromPropertyFile("staffPassword");
	
	JavaUtils jUtil=new JavaUtils();
	int random=jUtil.getRandomNo();
	
	//excel file handling for testscript data
	ExcelUtils eUtil=new ExcelUtils();
	eUtil.writeDataIntoExcel("OpenAccount", "pan1234"+random, 5, 1);
	HashMap<String, String> mapOpenAcc=eUtil.readMultipleData("OpenAccount");
	HashMap<String, String> mapDebitCard=eUtil.readMultipleData("ApplyDebitCard");
	
	//launch browser & navigate to application
	WebDriver driver=new ChromeDriver();

	
	WebDriverUtils wUtil=new WebDriverUtils();
	wUtil.maximizeWindow(driver);
	driver.get(URL);
	wUtil.waitForPageLoad(driver, 30);
	
	
	//click on open account tab 
	HomePage hp=new HomePage(driver);
	hp.clickOnOpenAccTab();

	
	//online account opening form page filling textfield filling
	OpenAccountPage oap=new OpenAccountPage(driver);
	oap.openAccount(driver, mapOpenAcc);
	oap.clickOnSubmitButton();
	
	//confirm account opening form
	OpenAccConfirmationPage oacp = new OpenAccConfirmationPage(driver);
	oacp.clickOnConfirmButton();
	
	//collecting application number from popup
	String appNo = oacp.appNoCollection(driver);
//	mapDebitCard.put("pan_no", appNo);
	
	//click on staff login link in homepage
	hp.clickOnStaffLoginLink();
	
	//staff login
	StaffLoginPage slp=new StaffLoginPage(driver);
	slp.StaffLogin(StaffUSERNAME, staffPassword);
	
	//click on approve pending Acc tab in staff homepage	
	StaffHomePage shp=new StaffHomePage(driver);
	shp.clickOnapprovePendingAccTab();
	

	//approving account
	ApprovePendingAccPage apap=new ApprovePendingAccPage(driver);
	apap.approveAcc(appNo, driver);
	apap.clickOnHomeButton();
	
	//view active cust and fetch acc no from pan no
	shp.clickOnviewActiveCustTab();
	//driver.findElement(By.name("viewdet")).click();
	String expectedPanNo=mapOpenAcc.get("pan_no");
	
	//get acc no from pan no
	//ActiveCustomerPage acp=new ActiveCustomerPage(driver);
	 
	//String accNo=acp.FindCustomerAccNoFromPan(expectedPanNo, driver);
	String accNo = driver.findElement(By.xpath("//tr/td[.='"+expectedPanNo+"']/preceding-sibling::td[5]")).getText();
	mapDebitCard.put("acc_no", accNo);
	shp.clickOnLogOutButton();
	driver.findElement(By.xpath("//img[@class='logo_img']")).click();
	
	
	//apply for debit card
	hp.clickOnapplyDebitCardTab();
	
	ApplyDebitCardPage adcp=new ApplyDebitCardPage(driver);
	adcp.applyDebitCard(mapDebitCard, driver);
	
	driver.quit();
	
	}
	
}

