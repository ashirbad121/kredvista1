package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\TestData.xlsx");
		
		 Workbook workbook = WorkbookFactory.create(fis);
		 
		 Sheet sheet = workbook.getSheet("Sheet2");
		 sheet.createRow(0).createCell(0).setCellValue("Hello");
		 sheet.getRow(0).createCell(1).setCellValue("Hiiii");
		// sheet.createRow(0).createCell(0).setCellValue("He54564645llo");
		 
		 FileOutputStream fos=new FileOutputStream("./src\\\\test\\\\resources\\\\TestData.xlsx");
		 workbook.write(fos);
		 workbook.close();
	}

}
