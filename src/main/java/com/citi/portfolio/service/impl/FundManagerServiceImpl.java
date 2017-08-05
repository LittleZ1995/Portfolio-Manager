package com.citi.portfolio.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.FundManager;
import com.citi.portfolio.entity.dao.FundManagerMapper;
import com.citi.portfolio.service.FundManagerService;

@Service("fundManagerService")
public class FundManagerServiceImpl implements FundManagerService{
	
	@Resource
	private FundManagerMapper fundManagerMapper;

	public FundManager getManagerById(int managerId) {
		return fundManagerMapper.selectByPrimaryKey(managerId);
	}

}
