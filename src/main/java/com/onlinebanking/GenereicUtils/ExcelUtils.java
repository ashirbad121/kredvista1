package com.onlinebanking.GenereicUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {

	/**
	 * This method is used to return data from excelsheet
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	/**
	 * This method is used to write data into excel file
	 * 
	 * @param sheetName
	 * @param data
	 * @param row
	 * @param cell
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName, String data, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelFilePath);
		workbook.write(fos);
		workbook.close();
	}

	/**
	 * This method is used to get the last row count of the given sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNo(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getLastRowNum();
	}

	public HashMap<String, String> readMultipleData(String sheetName) throws Throwable {
		//JavaUtils jLib = new JavaUtils();
		FileInputStream fis = new FileInputStream(IpathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int count = sheet.getLastRowNum();
		//empty HashMap creation
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i <= count; i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		

		return map;
		
		
	 		/*for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			*/
			
		 

	}
}
