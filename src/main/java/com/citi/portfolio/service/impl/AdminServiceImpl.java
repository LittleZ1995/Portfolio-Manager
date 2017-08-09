package com.citi.portfolio.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.BondMapper;
import com.citi.portfolio.entity.dao.EquityMapper;
import com.citi.portfolio.entity.dao.FutureMapper;
import com.citi.portfolio.entity.dao.PositionMapper;
import com.citi.portfolio.entity.dao.PriceMapper;
import com.citi.portfolio.service.AdminService;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {
	
	@Resource 
	private PriceMapper priceMapper;
	
	@Resource
	private BondMapper bondMapper; 
	
	@Resource
	private FutureMapper futureMapper;
	
	@Resource
	private EquityMapper equityMapper;
	
	@Resource
	private PositionMapper positionMapper;
	
	private static Integer largestPriceID;

	@Override
	public Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(priceMapper.getLatestDate());
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	@Override
	public void updateBondPrices(List<Bond> bonds, Date currentDate) {
		for (Bond bond : bonds) {
			Integer securityId = bond.getSecurityid();
			Price oldPrice = priceMapper.selectByPrimaryKey(bond.getPriceid());
			
			Price price = generatePrice(currentDate,oldPrice);
			price.setSecurityid(securityId);
			priceMapper.insert(price);
			
			bond.setPriceid(price.getPriceid());
			bondMapper.updateByPrimaryKey(bond);
			
			updatePositionPrice(securityId,price.getOfferprice());
		}
	}

	private void updatePositionPrice(Integer securityId, BigDecimal offerprice) {

		List<Position> positions = positionMapper.getPositionsBySecurityID(securityId);
		for (Position position : positions) {
			position.setCurrentprice(offerprice);
			positionMapper.updateByPrimaryKey(position);
		}
	}

	public Price generatePrice(Date currentDate,Price oldPrice) {
		Price price = new Price();
		price.setPriceid(++largestPriceID);
		price.setDate(currentDate);
		price.setCurrency("USD");
		price.setBidprice(autoGeneratePrice(oldPrice.getBidprice()));
		price.setOfferprice(autoGeneratePrice(oldPrice.getOfferprice()));
		return price;
	}

	protected BigDecimal autoGeneratePrice(BigDecimal oldPrice) {
		int changeSignal = Math.random() > 0.5 ? 1 : -1;
		double percentage = Math.random() * 0.1; 
		double old = oldPrice.doubleValue();
		double newPrice = old * ( 1 + percentage * changeSignal);
		return new BigDecimal(newPrice);
	}

	@Override
	public void updateFuturePrices(List<Future> futures, Date currentDate) {
		for (Future future : futures) {
			Integer securityId = future.getSecurityid();
			Price oldPrice = priceMapper.selectByPrimaryKey(future.getPriceid());
			
			Price price = generatePrice(currentDate,oldPrice);
			price.setSecurityid(securityId);
			priceMapper.insert(price);
			
			future.setPriceid(price.getPriceid());
			futureMapper.updateByPrimaryKey(future);
			
			updatePositionPrice(securityId,price.getOfferprice());
		}
		
	}

	@Override
	public void updateEquityPrices(List<Equity> equities, Date currentDate) {
		for (Equity equity : equities) {
			Integer securityId = equity.getSecurityid();
			Price oldPrice = priceMapper.selectByPrimaryKey(equity.getPriceid());
			
			Price price = generatePrice(currentDate,oldPrice);
			price.setSecurityid(securityId);
			priceMapper.insert(price);
			
			equity.setPriceid(price.getPriceid());
			equityMapper.updateByPrimaryKey(equity);
			
			updatePositionPrice(securityId,price.getOfferprice());
		}
	}
	
	public Integer getLargestPriceID(){
		largestPriceID = priceMapper.getLargestPriceID();
		return largestPriceID;
	}
	
}
