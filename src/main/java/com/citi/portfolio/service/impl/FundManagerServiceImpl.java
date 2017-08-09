package com.citi.portfolio.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.entity.Portfolio;
import com.citi.portfolio.entity.dao.FundManagerMapper;
import com.citi.portfolio.service.FundManagerService;
import com.citi.portfolio.service.PortfolioService;

@Service("fundManagerService")
public class FundManagerServiceImpl implements FundManagerService{
	
	@Resource
	private FundManagerMapper fundManagerMapper;
	
	@Resource
	private PortfolioService portfolioService;

	public FundManager getManagerById(int managerId) {
		return fundManagerMapper.selectByPrimaryKey(managerId);
	}

	public List<FundManager> getAllManagers() {
		// TODO Auto-generated method stub
		return fundManagerMapper.getAllManagers();
	}

	public int addManager(FundManager record) {
		// TODO Auto-generated method stub
		return fundManagerMapper.insert(record);
	}

	public int deleteManager(int managerid) {
		// TODO Auto-generated method stub
		return fundManagerMapper.deleteByPrimaryKey(managerid);
	}

	public FundManager selectByEmail(String email) {
		// TODO Auto-generated method stub
		return fundManagerMapper.selectByEmail(email);
	}

	@Override
	public Double calculateProfit(Integer managerid) {
		Double profit = 0d;
		List<Portfolio> portfolios = portfolioService.getAllPortfoliosOfManager(managerid);
		
		for (Portfolio portfolio : portfolios) {
			profit += portfolio.getProfit();
		}
		
		return profit;
	}

	@Override
	public int updateFundManager(FundManager manager) {
		return fundManagerMapper.updateByPrimaryKey(manager);
	}

}
