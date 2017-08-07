package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Price;

public interface EquityService {

	public List<Price> findAllHistoryPrices(int equityid);
	
}
