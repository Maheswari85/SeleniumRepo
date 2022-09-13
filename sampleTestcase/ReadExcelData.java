package sampleTestcase;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String [][] getData (String excelFileName) throws IOException {
//	locate and open the excel file
	XSSFWorkbook book = new XSSFWorkbook("./testdata/Book1.xlsx");	
		
//	Get into a particular Sheet
	XSSFSheet sheet = book.getSheetAt(0);
//	Get the total number of rows
	int rowNumber = sheet.getLastRowNum();
	System.out.println(rowNumber);
	
//	Get the total number of cols
	XSSFRow header = sheet.getRow(0);
	int colNumber = header.getLastCellNum();
	System.out.println(colNumber);	
//	Iterate over the rows to get each row for each iteration
		
		for (int i = 1; i<= rowNumber; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j<colNumber; j++) {
		XSSFCell eachCell = eachRow.getCell(j)	;	
		String cellValue = eachCell.getStringCellValue();
		System.out.println(cellValue);
				
				
			}
			
		}
		return getData(excelFileName);
		
	}















}
