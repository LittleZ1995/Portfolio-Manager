package com.citi.portfolio.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.Profit;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class PortfolioServiceTest {

	@Resource
	private PortfolioService portfolioService;
	
	@Test
	public void testgetAllHistoryProfit(){
		//List<Profit> getAllHistoryProfit(Integer portfolioid)
		List<Profit> historyProfit = portfolioService.getAllHistoryProfit(1);
		Assert.assertNull(historyProfit);
		
		Assert.assertTrue(1== historyProfit.get(0).getProfitid());

		//Assert.assertEquals(0, historyProfit.size());
		System.out.println("....  "+historyProfit);
		
	}
	
	
}
