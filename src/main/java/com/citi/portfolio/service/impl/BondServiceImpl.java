package com.citi.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.BondMapper;
import com.citi.portfolio.entity.dao.PriceMapper;
import com.citi.portfolio.service.BondService;

@Service("bondService")
public class BondServiceImpl implements BondService{

	@Resource 
	private BondMapper bondMapper;
	
	@Resource
	private PriceMapper priceMapper;

	public List<Price> findAllHistoryPrices(int bondid) {
		Bond bond = bondMapper.selectByPrimaryKey(bondid);
		Integer securityId = bond.getSecurityid();
		if(securityId != null && securityId.intValue() != 0){
			return priceMapper.selectBySecurityID(securityId);
		}else{
			return new ArrayList<Price>();
		}
		
	}

	@Override
	public Bond getBondBySecurityId(int securityid) {
		// TODO Auto-generated method stub
		return bondMapper.getBondBySecurityId(securityid);
	}

	@Override
	public List<Bond> getAllBonds() {
		// TODO Auto-generated method stub
		return bondMapper.getAllBonds();
	}
}
