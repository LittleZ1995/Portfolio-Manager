package com.citi.portfolio.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Price;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class EquityServiceTest {

	@Resource
	private EquityService equityService;
	
	
	@Test
	public void testFindAllHistoryPrices() {
		List<Price> historyPrices = equityService.findAllHistoryPrices(1);
		
		Assert.assertEquals(2, historyPrices.size());
		for (int i = 0; i < historyPrices.size(); i++) {
			System.out.println(historyPrices.get(i));
		}
	}
	
	@Test
	public void testGetEquityBySecurityId() {
		Equity equity = equityService.getEquityBySecurityId(6);
		Assert.assertNotNull(equity);
		Assert.assertEquals("ACET", equity.getSymbol());
	}
	
	@Test
	public void testGetAllEquities() {
		List<Equity> equities = equityService.getAllEquities();
		Assert.assertNotNull(equities);
		Assert.assertEquals(2, equities.size());
	}
	
}
