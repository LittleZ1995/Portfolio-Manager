package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.Profit;

public interface ProfitMapper {
    int deleteByPrimaryKey(Integer profitid);

    int insert(Profit record);

    int insertSelective(Profit record);

    Profit selectByPrimaryKey(Integer profitid);

    int updateByPrimaryKeySelective(Profit record);

    int updateByPrimaryKey(Profit record);
}