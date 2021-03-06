package com.citi.portfolio.service;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.stereotype.Component;

import com.citi.portfolio.entity.FundManager;

public interface FundManagerService {

	public FundManager getManagerById(int managerId);
	
	public List<FundManager> getAllManagers();
	
	public int addManager(FundManager record);
	
	public int deleteManager(int managerId);
	
	public FundManager selectByEmail(String email);

	public Double calculateProfit(Integer managerid);

	public int updateFundManager(FundManager manager);
	
	public void formatProfit(FundManager manager);
	
	public void formatProfit(List<FundManager> managers);  
}
