package com.citi.portfolio.entity.dao;

import com.citi.portfolio.entity.Portfolio;

public interface PortfolioMapper {
    int deleteByPrimaryKey(Integer portfolioid);

    int insert(Portfolio record);

    int insertSelective(Portfolio record);

    Portfolio selectByPrimaryKey(Integer portfolioid);

    int updateByPrimaryKeySelective(Portfolio record);

    int updateByPrimaryKey(Portfolio record);
}