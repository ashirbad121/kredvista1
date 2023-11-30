package com.DebitCard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class TC_13_OpenApproveAccApplyDebitCard {

	@Test()
	public void TC_13() throws IOException
	{
	//property file handling for common data
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonDataOnlineBanking.properties");
	Properties pObj=new Properties();
	pObj.load(fis);
	
	String URL=pObj.getProperty("url");
	String BROWSER=pObj.getProperty("browser");
	String StaffUSERNAME=pObj.getProperty("staffUsername");
	String staffPassword=pObj.getProperty("staffPassword");
	
	//excel file handling for testscript data
	FileInputStream fis1=new FileInputStream("src\\test\\resources\\TestData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	Sheet sheet = workbook.getSheet("OpenAccount");
	Sheet debitCardSheet=workbook.getSheet("ApplyDebitCard");
	
	Random r=new Random();
	int random=r.nextInt(999);
	
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	String pan = "pan1234";
	
	sheet.getRow(5).getCell(1).setCellValue(pan+random);
	workbook.write(fos);
	
	
	//create a empty hashmap
	HashMap<String, String> mapOpenAcc=new HashMap<String, String>();
	HashMap<String, String> mapDebitCard=new HashMap<String, String>();
	
	//storing values from excel to map
	int lastRowIndOpenAcc=sheet.getLastRowNum();
	int lastRowIndDebitCard = debitCardSheet.getLastRowNum();
	
	for(int i=0;i<lastRowIndOpenAcc;i++)
	{
		String key=sheet.getRow(i).getCell(0).getStringCellValue();
		String value=sheet.getRow(i).getCell(1).getStringCellValue();
		mapOpenAcc.put(key, value);
	}
	for(int i=0;i<=lastRowIndDebitCard;i++)
	{
		String key=debitCardSheet.getRow(i).getCell(0).getStringCellValue();
		String value=debitCardSheet.getRow(i).getCell(1).getStringCellValue();
		mapDebitCard.put(key, value);
	}
	
	
	
	
	//launch browser & navigate to application
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	//click on open account tab 
	driver.findElement(By.xpath("//li[.='Open Account']")).click();
	

	
	//online account opening form page filling textfield filling
	for(Entry<String, String> set:mapOpenAcc.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	//gender DD handling in acc opening page
	WebElement genderDD = driver.findElement(By.name("gender"));
	Select select=new Select(genderDD);
	select.selectByVisibleText(mapOpenAcc.get("gender"));
	
	//handling calender popup
	 WebElement calenderPopUp = driver.findElement(By.name("dob"));
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("arguments[0].value='12122000'", calenderPopUp);
	
	 
	 //handling city dropdwon
	 WebElement cityDD = driver.findElement(By.name("city"));
	 select=new Select(cityDD);
	 select.selectByVisibleText(mapOpenAcc.get("city"));
	 
	 driver.findElement(By.name("submit")).click();
	 
	
	driver.findElement(By.name("cnfrm-submit")).click();
	
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
	
	//staff login
	driver.findElement(By.linkText("Staff Login")).click();
	driver.findElement(By.name("staff_id")).sendKeys(StaffUSERNAME);
	driver.findElement(By.name("password")).sendKeys(staffPassword);
	driver.findElement(By.name("staff_login-btn")).click();
	
	//approving account
	driver.findElement(By.name("apprvac")).click();
	driver.findElement(By.name("application_no")).sendKeys(appNo);
	driver.findElement(By.name("search_application")).click();	
	try
	{
	driver.findElement(By.name("approve_cust")).click();	
	driver.switchTo().alert().accept();
	}
	catch(Exception e)
	{
		System.err.println("Failed");
	}
	
	//view active cust and fetch acc no
	driver.findElement(By.name("home")).click();
	driver.findElement(By.name("viewdet")).click();
	String expectedPanNo=mapOpenAcc.get("pan_no");
	
    String accNo = driver.findElement(By.xpath("//tr/td[.='"+expectedPanNo+"']/preceding-sibling::td[5]")).getText();
	mapDebitCard.put("acc_no", accNo);
	
	driver.findElement(By.name("logout_btn")).click();
	driver.findElement(By.xpath("//img[@class='logo_img']")).click();
	
	
	//apply for debit card
	driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
	
	for(Entry<String, String> set:mapDebitCard.entrySet())
	{
		if(set.getKey().equals("dob"))
		{
			 WebElement calenderPopUp1 = driver.findElement(By.name("dob"));
			 JavascriptExecutor js1=(JavascriptExecutor) driver;
			 js.executeScript("arguments[0].value='12122000'", calenderPopUp1);
		}
		else
		{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
	
	driver.findElement(By.name("dbt_crd_submit")).click();
	
	driver.quit();
	
	}
	
}

