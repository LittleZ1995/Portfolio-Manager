package com.citi.portfolio.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.PriceMapper;
import com.citi.portfolio.service.PriceService;
@Service("PriceService")
public class PriceServiceImpl implements PriceService {

	
	@Resource
	private PriceMapper priceMapper;
	
	@Override
	public Price getPriceById(int priceid) {
		return priceMapper.selectByPrimaryKey(priceid);
	}

	@Override
	public Date getLatestDate() {
		return priceMapper.getLatestDate();
	}

}
