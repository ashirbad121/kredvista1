package com.staffModule;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.onlinebanking.GenereicUtils.BaseClass;

@Listeners(com.onlinebanking.GenereicUtils.ListenerImplementation.class)
public class TC_15_DeleteAndViewCustomer extends BaseClass {
	
	String URL,StaffUSERNAME,staffPassword;
	WebDriver driver;
	@Test(retryAnalyzer = com.onlinebanking.GenereicUtils.RetryImplementClass.class)
	public void FetchTD() throws IOException, InterruptedException
	{
		//property file handling for common data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataOnlineBanking.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		URL=pObj.getProperty("url");
		StaffUSERNAME=pObj.getProperty("staffUsername");
		staffPassword=pObj.getProperty("staffPassword");
		
		//launch empty browser
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//enter url
		driver.get(URL);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		
		//staff login
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys(StaffUSERNAME);
		driver.findElement(By.name("password")).sendKeys(staffPassword);
		driver.findElement(By.name("staff_login-btn")).click();
		
		driver.findElement(By.name("viewdet")).click();
		
		Thread.sleep(3000);
		String custId = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
		String accNo=driver.findElement(By.xpath("//tr[2]/td[4]")).getText();
		
		 FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		 Workbook wb=WorkbookFactory.create(fs);
		 Sheet sh = wb.getSheet("Deleteaccount");
		 sh.getRow(0).getCell(1).setCellValue("'"+accNo);
		 sh.getRow(1).getCell(1).setCellValue("'"+custId);
		/* Workbook workbook = WorkbookFactory.create(fs);
		 workbook.getSheet("DeleteAccount").createRow(1).createCell(0).setCellValue(custId);
		 workbook.getSheet("DeleteAccount").createRow(0).createCell(0).setCellValue(accNo);*/
		 FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		 wb.write(fos);
		 driver.findElement(By.name("home")).click();
		 
		 
		
	}
	
	@Test(dependsOnMethods = "FetchTD",priority=1)
	public void staffModuleTest() throws IOException, InterruptedException {
		
	driver.findElement(By.name("del_cust")).click();
	
    FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
    
    Workbook wb=WorkbookFactory.create(fs);
	
    Sheet sh = wb.getSheet("DeleteAccount");
    
    int count=sh.getLastRowNum();
    
    HashMap<String, String> map=new HashMap<String, String>();
    
    for(int i=0;i<=count;i++) {
    	
    	String key=sh.getRow(i).getCell(0).getStringCellValue();
 
    	String value=sh.getRow(i).getCell(1).getStringCellValue();
    	
    	map.put(key, value);
    	
    }
    for(Entry<String,String> set: map.entrySet()) {
    	
    	
    		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
    	
    }
    
    driver.findElement(By.name("delete")).click();
    
	try
	{
		Alert a=driver.switchTo().alert();
		Thread.sleep(3000);
		a.accept();
	}
	catch(Exception e)
	{
		
	}
	
	
	
	driver.findElement(By.name("home")).click();
	
	driver.findElement(By.name("viewdet")).click();
	
	Assert.fail();
    
	
	try {
	driver.findElement(By.xpath("//td[text()='+map.get(\"Cust_ac_no\")+']"));
	}
	catch(Exception e) {
		System.out.println("Customer Account is Successfully deleted");
	}
	
	driver.quit();

}
}
