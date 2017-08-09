package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Price;

public interface FutureService {

	public List<Price> findAllHistoryPrices(int futureid);
	
	Future getFutureBySecurityId(int securityid);
	
	List<Future> getAllFutures();
}
