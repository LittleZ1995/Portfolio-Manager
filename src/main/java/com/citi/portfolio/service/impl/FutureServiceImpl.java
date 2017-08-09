package com.citi.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Future;
import com.citi.portfolio.entity.Price;
import com.citi.portfolio.entity.dao.FutureMapper;
import com.citi.portfolio.entity.dao.PriceMapper;
import com.citi.portfolio.service.FutureService;
@Service("FutureService")
public class FutureServiceImpl implements FutureService {

	@Resource
	private FutureMapper futureMapper;
	
	@Resource
	private PriceMapper priceMapper;
	
	public List<Price> findAllHistoryPrices(int futureid) {
		Future future = futureMapper.selectByPrimaryKey(futureid);
		Integer securityId = future.getSecurityid();
		if(securityId != null && securityId.intValue() != 0){
			return priceMapper.selectBySecurityID(securityId);
		} else {
			return new ArrayList<Price>();
		}
	}

	@Override
	public Future getFutureBySecurityId(int securityid) {
		// TODO Auto-generated method stub
		return futureMapper.getFutureBySecurityId(securityid);
	}

}
