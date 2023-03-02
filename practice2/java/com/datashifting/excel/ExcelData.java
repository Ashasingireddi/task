package com.datashifting.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.datashifting.model.EmployeDetails;

public class ExcelData {
	
//	check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType= file.getContentType();
		System.out.println("contentType==>"+contentType);
		if(contentType.equals("application/json"))
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}
	
//	convert excel to list format
	
	public static List<EmployeDetails> convertExcelToListOfEmployeDetails(InputStream inputStream)
	{
		List<EmployeDetails> list=new ArrayList<>();
		try
		{
			XSSFWorkbook workbook= new XSSFWorkbook(inputStream);
			System.out.println("workbook==>"+workbook);
			 XSSFSheet sheet=  workbook.getSheet("Sheet1");
			 
			 System.out.println("sheet==>"+sheet);
			 int rowno=0;
			 Iterator<Row> iterator=sheet.iterator();
			 
			 while(iterator.hasNext())
			 {
				 Row row=iterator.next();
				 if(rowno==0)
				 {
					 rowno++;
					 continue;
				 }
				 Iterator<Cell> cells=row.iterator();
				 int cid=0;
				 EmployeDetails employeDetails=new EmployeDetails();
				 while(cells.hasNext())
				 {
					 Cell cell=cells.next();
					 
					 switch(cid)
					 {
					 case 0:
						 employeDetails.setId((int)cell.getNumericCellValue());
						 break;
					 case 1:
						 employeDetails.setName(cell.getStringCellValue());
						 break;
					 case 2:
						 employeDetails.setAddress(cell.getStringCellValue());
						 break;
					 case 3:
						 employeDetails.setEmail(cell.getStringCellValue());
						 break;
					 case 4:
						 employeDetails.setPassword(cell.getStringCellValue());
						 break;
					 default:
						 break;
							 
						 }
					 cid++;
				 }
				 list.add(employeDetails);
				 
				 
			 }
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 return list;
		
	}

}
