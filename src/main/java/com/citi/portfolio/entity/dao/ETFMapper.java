package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.ETF;

public interface ETFMapper {
    int deleteByPrimaryKey(Integer etfid);

    int insert(ETF record);

    int insertSelective(ETF record);

    ETF selectByPrimaryKey(Integer etfid);

    int updateByPrimaryKeySelective(ETF record);

    int updateByPrimaryKey(ETF record);
}