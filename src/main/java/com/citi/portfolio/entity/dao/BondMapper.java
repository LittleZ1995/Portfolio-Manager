package com.citi.portfolio.entity.dao;

import java.util.List;

import com.citi.portfolio.entity.Bond;
import com.citi.portfolio.entity.Price;

public interface BondMapper {
    int deleteByPrimaryKey(Integer bondid);

    int insert(Bond record);

    int insertSelective(Bond record);

    Bond selectByPrimaryKey(Integer bondid);
    
    Bond selectByPrimaryKeyWithPrice(Integer bondid);

    int updateByPrimaryKeySelective(Bond record);

    int updateByPrimaryKey(Bond record);

	Bond selectByISIN(String iSIN);
	
	Bond getBondBySecurityId(int securityid);
}