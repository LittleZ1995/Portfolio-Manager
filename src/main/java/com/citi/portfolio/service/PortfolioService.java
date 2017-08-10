package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.entity.Profit;

public interface PortfolioService {
	
	public int addPortfolio(Portfolio portfolio);
	
	public int updatePortfolio(Portfolio portfolio);
	
	public List<Portfolio> getAllPortfoliosOfManager(int managerid);

	public Portfolio getPortfolioByPortfolioId(int portfolioid);
	
	public List<Portfolio> getAllPortfolios();

	public Double calculateProfit(Integer portfolioid);
	
	public List<Profit> getAllHistoryProfit(Integer portfolioid);
	
	public void formatProfit(Portfolio portfolio);
	
	public void formatProfit(List<Portfolio> portfolios);
}
