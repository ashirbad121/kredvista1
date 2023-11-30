package com.staffModule;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.onlinebanking.GenereicUtils.ExcelUtils;
import com.onlinebanking.GenereicUtils.FileUtils;
import com.onlinebanking.GenereicUtils.JavaUtils;
import com.onlinebanking.GenereicUtils.WebDriverUtils;

public class TC_15_DeleteAndViewCustomerUsingGenericUtils {
	
	ExcelUtils eUtil=new ExcelUtils();
	FileUtils fUtil=new FileUtils();
	JavaUtils jUtil=new JavaUtils();
	WebDriverUtils wUtil=new WebDriverUtils();
	
	
	
	String URL,StaffUSERNAME,staffPassword;
	WebDriver driver;
	@Test
	public void FetchTD() throws Throwable
	{
		
		
		URL=fUtil.readDataFromPropertyFile("url");
		StaffUSERNAME=fUtil.readDataFromPropertyFile("staffUsername");
		staffPassword=fUtil.readDataFromPropertyFile("staffPassword");
		
		//launch empty browser
		driver=new ChromeDriver();
		//maximize window
		wUtil.maximizeWindow(driver);
		//enter url
		driver.get(URL);
		//wait for pageLoad
		wUtil.waitForPageLoad(driver, 25);
		
		//staff login
		HomePage hp=new HomePage(driver);
		hp.clickOnStaffLoginLink();
		StaffLoginPage lp=new StaffLoginPage(driver);
		lp.StaffLogin(StaffUSERNAME,staffPassword);
		
		StaffHomePage shp=new StaffHomePage(driver);
		shp.clickOnviewActiveCustTab();
		//driver.findElement(By.name("viewdet")).click();
		String custId = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
		String accNo=driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
		
		// FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		 //Workbook wb=WorkbookFactory.create(fs);
		 //Sheet sh = wb.getSheet("Deleteaccount");
		 
		 //write fetched accno & custId into excel sheet
		 eUtil.writeDataIntoExcel("Deleteaccount", "'"+accNo, 0, 1);
		 eUtil.writeDataIntoExcel("Deleteaccount", "'"+custId, 1, 1);
	
		 //click on home button
		 shp.clickOnHomeButton();
		 //driver.findElement(By.name("home")).click();
		 
		 
		 
		
	}
	
	@Test(dependsOnMethods = "FetchTD",priority=1)
	public void staffModuleTest() throws Throwable {
		
	driver.findElement(By.name("del_cust")).click();
	
    int count=eUtil.getLastRowNo("DeleteAccount");
  
    HashMap<String, String> map = eUtil.readMultipleData("DeleteAccount");
    
    for (Entry<String, String> set : map.entrySet()) {
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
		}
    
    driver.findElement(By.name("delete")).click();
    
	try
	{
		wUtil.alertPopupAccept(driver);
	}
	catch(Exception e)
	{
		
	}
	StaffHomePage shp=new StaffHomePage(driver);
	shp.clickOnHomeButton();
	shp.clickOnviewActiveCustTab();

	
	try {
	driver.findElement(By.xpath("//td[text()='+map.get(\"Cust_ac_no\")+']"));
	}
	catch(Exception e) {
		System.out.println("Customer Account is Successfully deleted");
	}
	
	driver.quit();

}
}
