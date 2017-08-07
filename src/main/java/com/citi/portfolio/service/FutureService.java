package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Price;

public interface FutureService {

	public List<Price> findAllHistoryPrices(int futureid);
	
}
