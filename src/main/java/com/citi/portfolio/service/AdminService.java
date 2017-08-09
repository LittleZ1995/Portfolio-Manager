package com.citi.portfolio.service;

import java.util.Date;
import java.util.List;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.Security;

public interface AdminService {

	public Date getCurrentDate();

	public void updateBondPrices(List<Bond> bonds, Date currentDate);

	public void updateFuturePrices(List<Future> futures, Date currentDate);

	public void updateEquityPrices(List<Equity> equities, Date currentDate);
	
	public Integer getLargestPriceID();
	
	public Price generatePrice(Date currentDate,Price oldPrice);

}
