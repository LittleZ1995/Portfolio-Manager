package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Price;

public interface EquityService {

	public List<Price> findAllHistoryPrices(int equityid);
	
	Equity getEquityBySecurityId(int securityid);
	
	List<Equity> getAllEquities();
}
