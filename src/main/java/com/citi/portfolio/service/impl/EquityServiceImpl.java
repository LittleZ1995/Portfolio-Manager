package com.citi.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Equity;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.EquityMapper;
import com.citi.portfolio.entity.dao.PriceMapper;
import com.citi.portfolio.service.EquityService;

@Service("equityService")
public class EquityServiceImpl implements EquityService {

	@Resource
	private EquityMapper equityMapper;
	
	@Resource 
	private PriceMapper priceMapper;
	
	public List<Price> findAllHistoryPrices(int equityid) {
		Equity equity = equityMapper.selectByPrimaryKey(equityid);
		Integer securityId = equity.getSecurityid();
		if(securityId != null && securityId.intValue() !=0){
			return priceMapper.selectBySecurityID(securityId);
		}else{
			return new ArrayList<Price>();
		}
		
	}

}
