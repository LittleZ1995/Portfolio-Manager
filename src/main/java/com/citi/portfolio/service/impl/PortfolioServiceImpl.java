package com.citi.portfolio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.entity.dao.FundManagerMapper;
import com.citi.portfolio.entity.dao.PortfolioMapper;
import com.citi.portfolio.service.PortfolioService;

@Service("PortfolioService")
public class PortfolioServiceImpl implements PortfolioService {

	@Resource
	private PortfolioMapper portfolioMapper;
	
	public int addPortfolio(Portfolio portfolio) {
		// TODO Auto-generated method stub
		return portfolioMapper.insert(portfolio);
	}

	public List<Portfolio> getAllPortfoliosOfManager(int managerid) {
		// TODO Auto-generated method stub
		return portfolioMapper.getAllPortfoliosOfManager(managerid);
	}

}
