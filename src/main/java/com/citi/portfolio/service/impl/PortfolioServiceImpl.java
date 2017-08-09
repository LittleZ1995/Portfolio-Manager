package com.citi.portfolio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.entity.Position;
import com.citi.portfolio.entity.dao.FundManagerMapper;
import com.citi.portfolio.entity.dao.PortfolioMapper;
import com.citi.portfolio.entity.dao.ProfitMapper;
import com.citi.portfolio.service.PortfolioService;
import com.citi.portfolio.service.PositionService;
import com.citi.portfolio.entity.Profit;

@Service("PortfolioService")
public class PortfolioServiceImpl implements PortfolioService {

	@Resource
	private PortfolioMapper portfolioMapper;
	
	@Resource
	private ProfitMapper profitMapper;
	
	@Resource
	private PositionService positionService;
	
	public int addPortfolio(Portfolio portfolio) {
		// TODO Auto-generated method stub
		return portfolioMapper.insert(portfolio);
	}

	public List<Portfolio> getAllPortfoliosOfManager(int managerid) {
		// TODO Auto-generated method stub
		return portfolioMapper.getAllPortfoliosOfManager(managerid);
	}

	@Override
	public Portfolio getPortfolioByPortfolioId(int portfolioid) {
		// TODO Auto-generated method stub
		return portfolioMapper.selectByPrimaryKey(portfolioid);
	}

	@Override
	public List<Portfolio> getAllPortfolios() {
		return portfolioMapper.getAllPortfolios();
	}

	@Override
	public int updatePortfolio(Portfolio portfolio) {
		return portfolioMapper.updateByPrimaryKey(portfolio);
	}

	@Override
	public Double calculateProfit(Integer portfolioid) {
		Double profit = 0d;
		List<Position> positions = positionService.getAllPositionsOfPortfolio(portfolioid);
		for (Position position : positions) {
			profit += position.getProfit();
		}
		return profit;
	}

	@Override
	public List<Profit> getAllHistoryProfit(Integer portfolioid) {
		return profitMapper.selectByPortfolioId(portfolioid);
	}

}
