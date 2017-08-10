package com.citi.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Profit;
import com.citi.portfolio.service.ProfitService;
import com.citi.portfolio.util.DoubleFormat;

@Service("ProfitService")
public class ProfitServiceImpl implements ProfitService{

	@Override
	public void formatProfit(List<Profit> profits) {
		// TODO Auto-generated method stub
		for (Profit profit : profits) {
			profit.setProfitvalue(DoubleFormat.format(profit.getProfitvalue()));
		}
	}

}
