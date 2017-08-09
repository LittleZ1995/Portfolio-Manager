package com.citi.portfolio.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.BondMapper;
import com.citi.portfolio.entity.dao.PositionMapper;
import com.citi.portfolio.entity.dao.PriceMapper;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class AdminServiceTest {
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private BondMapper bondMapper;
	
	@Resource
	private PriceMapper priceMapper;
	
	@Resource
	private PositionMapper positionMapper;
	
	@Test
	public void testUpdateBondServices(){
		Bond bond = bondMapper.selectByPrimaryKey(348);
		
		Date currentDate = priceMapper.getLatestDate();
		
		adminService.saveHistoryProfit(currentDate);
		
		Integer securityId = bond.getSecurityid();
		Price oldPrice = priceMapper.selectByPrimaryKey(bond.getPriceid());
		
		adminService.getLargestPriceID();
		Price price = adminService.generatePrice(currentDate,oldPrice);
		price.setSecurityid(securityId);
		priceMapper.insert(price);
		
		bond.setPriceid(price.getPriceid());
		bondMapper.updateByPrimaryKey(bond);
		
		adminService.updatePositionPrice(securityId, price.getOfferprice());
		
		adminService.updatePortolioProfit();
		
		adminService.updateManagerProfit();	
		
	}
}
