package com.citi.portfolio.service;

import org.springframework.stereotype.Component;

import com.citi.portfolio.entity.FundManager;

public interface FundManagerService {

	public FundManager getManagerById(int managerId);
}
