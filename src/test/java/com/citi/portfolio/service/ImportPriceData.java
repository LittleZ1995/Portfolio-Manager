package com.citi.portfolio.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.Security;
import com.citi.portfolio.entity.dao.BondMapper;
import com.citi.portfolio.entity.dao.EquityMapper;
import com.citi.portfolio.entity.dao.FutureMapper;
import com.citi.portfolio.entity.dao.PriceMapper;
import com.citi.portfolio.entity.dao.SecurityMapper;
import com.sun.java_cup.internal.runtime.Symbol;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class ImportPriceData {

    private XSSFWorkbook workbook;
    
    @Resource
    private BondMapper bondMapper;
    
    @Resource
    private FutureMapper futureMapper;
    
    @Resource
    private EquityMapper equityMapper;
    
    @Resource
    private PriceMapper priceMapper;
    
    @Resource 
    private SecurityMapper securityMapper;
    
//    private static int securityNum = 0;
	
//    private static int securityNum = 132;
    
    private static int securityNum = 264;
    
    @Before
	public void setUp() throws FileNotFoundException, IOException{
		File dataFile = new File("src/main/resources/Data/data.xlsx");
		if(!dataFile.exists()){
			System.out.println("File not exist");
		    return ;
		}
		workbook = new XSSFWorkbook(new FileInputStream(dataFile));
	}
	
	@Test
	public void importBondPriceData(){
		Sheet bondSheet = workbook.getSheet("Bond");
		
        Map<String, List<Price>> pricesMap = new HashMap<String, List<Price>>();
		
		for (int i = 1; i <= bondSheet.getLastRowNum(); i++) {
			Row row = bondSheet.getRow(i);
			
			String ISIN = formatISIN(row.getCell(1).getNumericCellValue());
			List<Price> prices = pricesMap.get(ISIN);
			if(prices == null){
				prices = new ArrayList<>();
				pricesMap.put(ISIN,prices);
			}
			
			Price price = new Price();
			price.setPriceid((int) row.getCell(0).getNumericCellValue());
			price.setCurrency("USD");
			price.setBidprice(new BigDecimal(row.getCell(2).getNumericCellValue()));
			price.setOfferprice(new BigDecimal(row.getCell(3).getNumericCellValue()));
			price.setDate(row.getCell(4).getDateCellValue());
			
			prices.add(price);
		}
		
		saveBondPrice2DB(pricesMap);
		
		System.out.println("Success to import bond-price data");
		
	}

	private void saveBondPrice2DB(Map<String, List<Price>> pricesMap) {
		for (Map.Entry<String, List<Price>> entry : pricesMap.entrySet()) {
			String ISIN = entry.getKey();
			List<Price> prices= entry.getValue();
			
			Bond bond = bondMapper.selectByISIN(ISIN);
			if(bond != null){
				Security security = new Security();
				security.setSecurityid(++securityNum);
				security.setSecuritytype("bond");
				securityMapper.insert(security);
				
				for (int i = 0; i < prices.size(); i++) {
					prices.get(i).setSecurityid(securityNum);
					priceMapper.insert(prices.get(i));
				}
				
				Price latestPrice = prices.get(prices.size()-1);
				bond.setPriceid(latestPrice.getPriceid());
				bond.setSecurityid(securityNum);
				bondMapper.updateByPrimaryKey(bond);
				
			}
			
		}
	}
	
	@Test
	public void importFuturePriceData(){
		Sheet futureSheet = workbook.getSheet("Future");
		
		Map<String, List<Price>> pricesMap = getPricesMap(futureSheet);
		
		saveFuturePrice2DB(pricesMap);
		
		System.out.println("Success to import future-price data");
		
	}
	
	private void saveFuturePrice2DB(Map<String, List<Price>> pricesMap) {
		for (Map.Entry<String, List<Price>> entry : pricesMap.entrySet()) {
			String symbol = entry.getKey();
			List<Price> prices= entry.getValue();
			
			Future future = futureMapper.selectBySymbol(symbol);
			if(future != null){
				Security security = new Security();
				security.setSecurityid(++securityNum);
				security.setSecuritytype("future");
				securityMapper.insert(security);
				
				for (int i = 0; i < prices.size(); i++) {
					prices.get(i).setSecurityid(securityNum);
					priceMapper.insert(prices.get(i));
				}
				
				Price latestPrice = prices.get(prices.size()-1);
				future.setPriceid(latestPrice.getPriceid());
				future.setSecurityid(securityNum);
				futureMapper.updateByPrimaryKey(future);
				
			}
			
		}
	}
	
	@Test
	public void importEquityPriceData(){
		Sheet bondSheet = workbook.getSheet("Equity");
		
		Map<String, List<Price>> pricesMap = getPricesMap(bondSheet);
		
		saveEquityPrice2DB(pricesMap);
		
		System.out.println("Success to import equity-price data");
		
	}

	private void saveEquityPrice2DB(Map<String, List<Price>> pricesMap) {
		for (Map.Entry<String, List<Price>> entry : pricesMap.entrySet()) {
			String symbol = entry.getKey();
			List<Price> prices= entry.getValue();
			
			Equity equity = equityMapper.selectBySymbol(symbol);
			if(equity != null){
				Security security = new Security();
				security.setSecurityid(++securityNum);
				security.setSecuritytype("equity");
				securityMapper.insert(security);
				
				for (int i = 0; i < prices.size(); i++) {
					prices.get(i).setSecurityid(securityNum);
					priceMapper.insert(prices.get(i));
				}
				
				Price latestPrice = prices.get(prices.size()-1);
				equity.setPriceid(latestPrice.getPriceid());
				equity.setSecurityid(securityNum);
				equityMapper.updateByPrimaryKey(equity);
				
			}
			
		}
	}

	private Map<String, List<Price>> getPricesMap(Sheet sheet) {
		Map<String, List<Price>> pricesMap = new HashMap<String, List<Price>>();
		
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			
			String securityName = row.getCell(1).getStringCellValue();
			List<Price> prices = pricesMap.get(securityName);
			if(prices == null){
				prices = new ArrayList<>();
				pricesMap.put(securityName,prices);
			}
			
			Price price = new Price();
			price.setPriceid((int) row.getCell(0).getNumericCellValue());
			price.setCurrency("USD");
			price.setBidprice(new BigDecimal(row.getCell(2).getNumericCellValue()));
			price.setOfferprice(new BigDecimal(row.getCell(3).getNumericCellValue()));
			price.setDate(row.getCell(4).getDateCellValue());
			
			prices.add(price);
		}
		return pricesMap;
	}

	//used when import bond-price data
	private String formatISIN(double numericCellValue) {
		DecimalFormat format = new DecimalFormat("0");
		return format.format(numericCellValue);
	}
}
