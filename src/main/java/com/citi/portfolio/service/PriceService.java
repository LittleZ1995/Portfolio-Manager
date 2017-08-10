package com.citi.portfolio.service;

import java.util.Date;

import com.citi.portfolio.entity.Price;

public interface PriceService {
	public Price getPriceById(int priceid);
	
	Date getLatestDate();
}
