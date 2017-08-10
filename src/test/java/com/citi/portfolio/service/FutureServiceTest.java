package com.citi.portfolio.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Price;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class FutureServiceTest {

	@Resource
	private FutureService futureService;
	
	@Test
	public void testFindAllHistoryPrices() {
		List<Price> historyPrices = futureService.findAllHistoryPrices(1);
		
		Assert.assertEquals(2, historyPrices.size());
		for (int i = 0; i < historyPrices.size(); i++) {
			System.out.println(historyPrices.get(i));
		}
	}
	
	@Test
	public void testGetEquityBySecurityId() {
		Future future = futureService.getFutureBySecurityId(2);
		Assert.assertNotNull(future);
		Assert.assertEquals("LC 201710", future.getSymbol());
	}
	
	@Test
	public void testGetAllEquities() {
		List<Future> futures = futureService.getAllFutures();
		Assert.assertNotNull(futures);
		Assert.assertEquals(2, futures.size());
	}
	
}
