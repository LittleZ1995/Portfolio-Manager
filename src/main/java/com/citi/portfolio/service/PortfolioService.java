package com.citi.portfolio.service;

import java.util.List;

import com.citi.portfolio.entity.Portfolio;

public interface PortfolioService {
	
	public int addPortfolio(Portfolio portfolio);
	
	public List<Portfolio> getAllPortfoliosOfManager(int managerid);

	Portfolio getPortfolioByPortfolioId(int portfolioid);
}
