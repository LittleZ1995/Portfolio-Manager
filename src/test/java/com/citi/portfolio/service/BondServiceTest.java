package com.citi.portfolio.service;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.BondMapper;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class BondServiceTest {
	
	@Resource
	private BondService bondService;
	
	@Resource
	private BondMapper bondMapper;
	
	@Test
	public void testSelect(){
		Bond bond = bondMapper.selectByPrimaryKeyWithPrice(1);
		System.out.println(bond.getPrice());
	}
	
	@Test
	public void testSelectByISIN(){
		Bond bond = bondMapper.selectByISIN("1234567890");
		System.out.println(bond);
	}

	
	@Test
	public void testFindAllHistoryPrices(){
		List<Price> historyPrices = bondService.findAllHistoryPrices(1);
		Assert.assertEquals(2, historyPrices.size());
		for (int i = 0; i < historyPrices.size(); i++) {
			System.out.println(historyPrices.get(i));
		}
		
	}
	
	@Test
	public void testGetBondBySecurityId() {
		Bond bond = bondService.getBondBySecurityId(1);
		Assert.assertNotNull(bond);
		//Assert.assertEquals("1234567890", bond.getIsin());
	}
	

	@Test
	public void testGetAllBonds() {
		List<Bond> bonds = bondService.getAllBonds();
		Assert.assertNotNull(bonds);
		Assert.assertEquals(3, bonds.size());
	}
	
}
