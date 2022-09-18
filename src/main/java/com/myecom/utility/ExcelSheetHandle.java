package com.myecom.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.myecom.base.BaseClass;

public class ExcelSheetHandle extends BaseClass
{
	public static FileInputStream fis;
	
	public static FileInputStream getExcelFile() throws FileNotFoundException
	{
		 fis=new FileInputStream(projectPath+"//src//test//resources//testdata//AllData.xlsx");
		return fis;
	}
	public Sheet getSheet(FileInputStream fileName,String sheetName) 
	{
		Sheet sh=null;
		try 
		{
		 sh=WorkbookFactory.create(fileName).getSheet(sheetName);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return sh;
	}
	public Map<String, Object> getExcelSheetData(Sheet sh)
	{
		int getRow=sh.getLastRowNum();
		System.out.println("rows are "+getRow);
		Map<String,Object> data=new HashMap();
		for(int i=0;i<getRow;i++)
		{
			int col=sh.getRow(i).getLastCellNum();
			System.out.println("cell are "+col);
			for(int j=0;j<col;j++)
			{
				 //if(sh.getRow(i).getCell(j).getCellType().name().equals("STRING"))
				if(sh.getRow(i+1).getCell(j).getCellType().name().equals("STRING"))
				 {
				  data.put(sh.getRow(0).getCell(j).getStringCellValue(),sh.getRow(i+1).getCell(j).getStringCellValue()); 
				 } 
				//else if(sh.getRow(i).getCell(j).getCellType().name().equals("NUMERIC"))
				else if(sh.getRow(i+1).getCell(j).getCellType().name().equals("NUMERIC"))
				{   
					//String abc=sh.getRow(i).getCell(j).toString();
				   String number=String.valueOf((long)sh.getRow(i+1).getCell(j).getNumericCellValue());	
		           data.put(sh.getRow(0).getCell(j).getStringCellValue(),number);		
				}
			}		
		 }
		return data;
	   }	
	}
	

