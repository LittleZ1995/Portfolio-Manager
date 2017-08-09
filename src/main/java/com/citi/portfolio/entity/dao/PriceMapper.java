package com.citi.portfolio.entity.dao;

import java.util.Date;
import java.util.List;

import com.citi.portfolio.entity.Price;

public interface PriceMapper {
    int deleteByPrimaryKey(Integer priceid);

    int insert(Price record);

    int insertSelective(Price record);

    Price selectByPrimaryKey(Integer priceid);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);

	List<Price> selectBySecurityID(int securityId);

	Date getLatestDate();

	Integer getLargestPriceID();
}