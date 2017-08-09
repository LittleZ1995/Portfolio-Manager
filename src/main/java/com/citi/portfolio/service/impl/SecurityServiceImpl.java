package com.citi.portfolio.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.citi.portfolio.entity.Security;
import com.citi.portfolio.entity.dao.SecurityMapper;
import com.citi.portfolio.service.SecurityService;

@Service("SecurityService")
public class SecurityServiceImpl implements SecurityService {

	
	@Resource
	private SecurityMapper securityMapper;
	
	@Override
	public Security getSecurityTypeById(int securityid) {
		// TODO Auto-generated method stub
		return securityMapper.getSecurityTypeById(securityid);
	}

}
