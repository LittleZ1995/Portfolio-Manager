package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Price;

public interface BondService {

	public List<Price> findAllHistoryPrices(int bondid);
	
}
