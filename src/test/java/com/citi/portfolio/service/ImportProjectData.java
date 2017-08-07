package com.citi.portfolio.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.dao.BondMapper;
import com.citi.portfolio.entity.dao.EquityMapper;
import com.citi.portfolio.entity.dao.FutureMapper;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class ImportProjectData {
	
	@Resource
    public BondMapper bondMapper;
	
	@Resource
	public FutureMapper futureMapper;
	
	@Resource
	public EquityMapper equityMapper;
	
	private XSSFWorkbook workbook;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException{
		File dataFile = new File("src/main/resources/Data/ProjectData.xlsx");
		if(!dataFile.exists()){
			System.out.println("File not exist");
		    return ;
		}
		workbook = new XSSFWorkbook(new FileInputStream(dataFile));
	}
	
	
	@Test
	public void ImportBondData() throws FileNotFoundException, IOException{
		
		Sheet bondSheet = workbook.getSheet("Bonds");
		
		for (int i = 1; i < 100; i++) {
			Bond bond = new Bond();
			Row row = bondSheet.getRow(i);
			bond.setIssuer(row.getCell(0).getStringCellValue());
			bond.setCoupon(row.getCell(1).getNumericCellValue());
			int month = getMonth(row.getCell(2).getStringCellValue());
			int year = (int) row.getCell(3).getNumericCellValue() - 1900;
			bond.setMaturity(new Date(year, month, 1));
			
			bondMapper.insert(bond);
		}
		
		System.out.println("Success to import Bond Data");
		
		return ;
		
	}
	
	@Test
	public void ImportFutureData(){
		Sheet futureSheet = workbook.getSheet("Futures");
		
		for (int i = 1; i < 100; i++) {
			Row row = futureSheet.getRow(i);
			Future future = new Future();
			future.setSymbol(row.getCell(2).getStringCellValue());
			future.setDeliverydate(row.getCell(5).getDateCellValue());
			futureMapper.insert(future);
		}
		
		System.out.println("Success to import Future Data");
		
	}
	
	@Test
	public void ImportEquityData(){
		Sheet equitySheet = workbook.getSheet("NYSE Symbols");
		
		for (int i = 1; i < 100; i++) {
			Row row = equitySheet.getRow(i);
			Equity equity = new Equity();
			equity.setSymbol(row.getCell(0).getStringCellValue());
			equityMapper.insert(equity);
		}
		
		System.out.println("Success to import Equity Data");
		
	}
	
	

	private int getMonth(String month) {
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
//		if("JAN".equals(month)){
//			return 0;
//		}
		
		switch (month) {
		case "JAN":
			return 0;
		case "FEB":
			return 1;
		case "MAR":
			return 2;
		case "APR":
			return 3;
		case "MAY":
			return 4;
		case "JUN":
			return 5;
		case "JUL":
			return 6;
		case "AUG":
			return 7;
		case "SEP":
			return 8;
		case "OCT":
			return 9;
		case "NOV":
			return 10;
		case "DEC":
			return 11;
		default:
			return 0;
		}
	}
}
