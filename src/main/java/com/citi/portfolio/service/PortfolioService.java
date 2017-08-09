package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Portfolio;

public interface PortfolioService {
	
	public int addPortfolio(Portfolio portfolio);
	
	public int updatePortfolio(Portfolio portfolio);
	
	public List<Portfolio> getAllPortfoliosOfManager(int managerid);

	public Portfolio getPortfolioByPortfolioId(int portfolioid);
	
	public List<Portfolio> getAllPortfolios();

	public Double calculateProfit(Integer portfolioid);
}
