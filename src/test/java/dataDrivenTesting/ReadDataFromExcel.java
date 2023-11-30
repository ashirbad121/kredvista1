package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//get obj for physical representation
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheet("Sheet1");
	/*	String header=sheet.getRow(0).getCell(0).getStringCellValue();
		String orgName=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(header+"-->"+orgName);
		*/
		
		int rowCount=sheet.getLastRowNum();//it returns =>=>the index of last row=>total_rowcount-1
		int cellCount=sheet.getRow(0).getLastCellNum();//returns index of last cell+1
		
		for(int i=0;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				String value=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
